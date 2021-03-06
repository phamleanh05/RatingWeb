package com.java.RateSystem.service;

import com.java.RateSystem.models.Servicerate;
import com.java.RateSystem.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Servicerate> getAll() {
        return serviceRepository.findAll();
    }

    public Optional<Servicerate> findById(@PathVariable Integer id) {
        return serviceRepository.findByServiceId(id);
    }

    public Optional<Servicerate> findByUUId(@PathVariable UUID uuid) {
        return serviceRepository.findByUUId(uuid);
    }

    public void deleteById(@PathVariable Integer id) {serviceRepository.deleteById(id);}

    public boolean existsById(@PathVariable Integer id) {
        return serviceRepository.existsById(id);
    }

    public Servicerate save(@RequestBody Servicerate newService) { return serviceRepository.save(newService);}
}
