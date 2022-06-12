package com.java.RateSystem.repository;

import com.java.RateSystem.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    @Query("SELECT s FROM Rating s WHERE s.id = ?1")
    Optional<Rating> findByRateId(Integer id);

//    @Query("SELECT s FROM Rating s WHERE s.uuid = ?1")
//    Optional<Rating> findByUUId(UUID uuid);

    @Query("SELECT s FROM Rating s WHERE s.serviceid = ?1")
    List<Rating> findByServiceId(Integer serviceid);

    @Modifying
    @Query("delete from Rating r where r.id = ?1")
    void deleteByRateId(Integer id);
}
