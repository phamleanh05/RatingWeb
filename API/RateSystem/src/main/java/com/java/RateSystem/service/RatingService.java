package com.java.RateSystem.service;

import com.java.RateSystem.models.Rating;
import com.java.RateSystem.models.Servicerate;
import com.java.RateSystem.repository.RatingRepository;
import com.java.RateSystem.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.UUID;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> findById(@PathVariable Integer id) {
        return ratingRepository.findById(id);
    }

    public Optional<Rating> findByUUId(@PathVariable UUID uuid){
        return ratingRepository.findByUUId(uuid);
    }


    public void deleteRating(@PathVariable UUID id) {
        ratingRepository.deleteById(id);
    }

    public boolean isRatingExist(@PathVariable UUID id) {
        return ratingRepository.existsById(id);
    }

    public Rating saveRating(@RequestBody Rating newRating) {
        return ratingRepository.save(newRating);
    }

    public OptionalDouble calculate(Rating newRating){
        List<Rating> findRatingbyServiceID = ratingRepository.findByServiceId(newRating.getServiceid());
        OptionalDouble avg=  findRatingbyServiceID.stream().mapToDouble(i-> i.getPoint()).average();
        return avg;
    }

    public void updateavg(Rating newRating){
        Servicerate foundServices = serviceRepository.findByServiceId(newRating.getServiceid()).get();
        Double avg = calculate(newRating).orElse(0);
        if(foundServices != null){
            foundServices.setAvgscore(avg);
            serviceRepository.save(foundServices);
        }
    }

    public boolean checkRating(Rating newRaing){
        if(newRaing.getDate() == null || newRaing.getPoint() == null ||
                newRaing.getServiceid() == null || newRaing.getUsername() == null) {
            return false;
        }
        else
            return true;
    }
}
