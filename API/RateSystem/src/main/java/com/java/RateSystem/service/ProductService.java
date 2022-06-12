package com.java.RateSystem.service;

import com.java.RateSystem.models.Servicerate;
import com.java.RateSystem.models.User;
import com.java.RateSystem.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Servicerate> listAll(){
        return serviceRepository.findAll(Sort.by("avgscore").ascending());
    }
    public List<Servicerate> getAll() {
        return serviceRepository.findAll();
    }

    public Optional<Servicerate> findById(@PathVariable Integer id) {
        return serviceRepository.findByServiceId(id);
    }


    public void deleteById(@PathVariable Integer id) {serviceRepository.deleteByServiceId(id);}



    public Servicerate save(@RequestBody Servicerate newService) { return serviceRepository.save(newService);}
}
