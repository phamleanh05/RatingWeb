package com.java.RateSystem.repository;

import com.java.RateSystem.models.Options;
import com.java.RateSystem.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Options,Long> {
    @Query("SELECT o FROM Options o WHERE o.serviceid = ?1")
    List<Options> findByServiceId(Integer serviceid);
}
