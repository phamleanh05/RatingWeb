package com.java.RateSystem.service;

import com.java.RateSystem.models.Options;
import com.java.RateSystem.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    public List<Options> getAll() {
        return optionRepository.findAll();
    }

    public Optional<Options> findById(@PathVariable Integer id) {
        return optionRepository.findById(id);
    }

    public void deleteById(@PathVariable Integer id) {optionRepository.deleteById(id);}

    public boolean existedId(@PathVariable Integer id){return optionRepository.existsById(id);}

    public Options save(@RequestBody Options newOption) { return optionRepository.save(newOption);}
}
