package com.java.RateSystem.repository;

import com.java.RateSystem.models.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Options,Long> {

}
