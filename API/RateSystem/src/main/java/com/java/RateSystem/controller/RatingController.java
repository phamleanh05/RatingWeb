package com.java.RateSystem.controller;

import com.java.RateSystem.models.Rating;
import com.java.RateSystem.models.ResponseObject;
import com.java.RateSystem.models.Servicerate;
import com.java.RateSystem.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping(path = "api/v1/rate")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @GetMapping("")
    List<Rating> getAllService(){
        return ratingService.getAll();
    }

    @GetMapping("{id}")
    ResponseEntity<ResponseObject>findByUUId(@PathVariable UUID id){
        Optional<Rating> foundService = ratingService.findByUUId(id);
        return foundService.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Querry Service successfully", foundService)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("false", "Cannot find Service with id =" + id,"")
                );

    }

    //insert data
    @PostMapping("")
    ResponseEntity<ResponseObject> insertRating(@RequestBody Rating newRate){
        Optional<Rating> foundRate = ratingService.findById(newRate.getId());
        if (foundRate.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "The Rating has existed"," ")
            );
        } else {
            ratingService.saveRating(newRate);
            ratingService.updateavg(newRate);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Insert Rating successfully",newRate)
            );
        }
    }

    //Update data
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateRate(@RequestBody Rating newRate, @PathVariable Integer id){
        Rating updateRate =  ratingService.findById(id)
                .map(rate -> {
                    rate.setUsername(newRate.getUsername());
                    rate.setServiceid(newRate.getServiceid());
                    rate.setPoint(newRate.getPoint());
                    rate.setComment(newRate.getComment());
                    rate.setDate(newRate.getDate());
                    return ratingService.saveRating(rate);
                }).orElseGet(()->{
                    newRate.setId(id);
                    return ratingService.saveRating(newRate);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Update Rate successfully",ratingService.saveRating(newRate))
        );
    }



    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteRate (@PathVariable Integer id){
        Optional<Rating> foundService = ratingService.findById(id);
        if(foundService.isPresent())
        {
            ratingService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Delete Service successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed", "Cannot find Service to delete ", "")
        );
    }
}
