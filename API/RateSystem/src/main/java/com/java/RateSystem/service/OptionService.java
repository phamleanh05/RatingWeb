package com.java.RateSystem.service;

import com.java.RateSystem.models.Options;
import com.java.RateSystem.models.Rating;
import com.java.RateSystem.models.Servicerate;
import com.java.RateSystem.repository.OptionRepository;
import com.java.RateSystem.repository.RatingRepository;
import com.java.RateSystem.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@Transactional
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Options> getAll() {
        return optionRepository.findAll();
    }

    public Optional<Options> findById(@PathVariable long id) {
        return optionRepository.findById(id);
    }
    public List<Options> findByServiceId(@PathVariable Integer id) {
        return optionRepository.findByServiceId(id);
    }

    public void deleteById(@PathVariable long id) {optionRepository.deleteById(id);}

    public boolean existedId(@PathVariable long id){return optionRepository.existsById(id);}

    public Options saveOpt(@RequestBody Options newOption) { return optionRepository.save(newOption);}

    public OptionalDouble calculate(Options newOpt){
        List<Options> findOptId = optionRepository.findByServiceId(newOpt.getServiceid());
        OptionalDouble avg=  findOptId.stream().mapToDouble(i-> i.getPoint()).average();
        return avg;
    }

    public void updateavg(Options newOpt){
        Servicerate foundServices = serviceRepository.findByServiceId(newOpt.getServiceid()).get();
        Double avg = calculate(newOpt).orElse(0);
        if(foundServices != null){
            foundServices.setAvgscore(avg);
            serviceRepository.save(foundServices);
        }
    }
}
