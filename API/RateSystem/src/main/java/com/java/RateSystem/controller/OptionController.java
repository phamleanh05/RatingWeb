package com.java.RateSystem.controller;

import com.java.RateSystem.models.Options;
import com.java.RateSystem.models.Rating;
import com.java.RateSystem.models.ResponseObject;
import com.java.RateSystem.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RestController
@RequestMapping(path = "api/v1/option")
public class OptionController {
    @Autowired
    private OptionService optionService;

    @GetMapping("")
    List<Options> getAll(){
        return optionService.getAll();
    }

    @GetMapping("{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable long id){
        Optional<Options> foundOption = optionService.findById(id);
        return foundOption.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject(foundOption)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("")
                );
    }

    //insert data
    @PostMapping("")
    public ResponseEntity<ResponseObject> addOptions(@RequestBody Options newOption){
        Optional<Options> foundOption = optionService.findById(newOption.getId());
        if (foundOption.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("")
            );
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(optionService.save(newOption))
            );
        }
    }

    //Update data
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateOptions(@RequestBody Options newOpt, @PathVariable long id){
        Options updateOpt =  optionService.findById(id)
                .map(options -> {
                    options.setName(newOpt.getName());
                    options.setServiceid(newOpt.getServiceid());
                    options.setServiceName(newOpt.getServiceName());
                    options.setPoint(newOpt.getPoint());
                    return optionService.save(options);
                }).orElseGet(()->{
                    newOpt.setId(id);
                    return optionService.save(newOpt);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(optionService.save(newOpt))
        );
    }



    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteOptions (@PathVariable long id){
        boolean exists = optionService.existedId(id);
        if(exists)
        {
            optionService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject( "")
        );
    }
}
