package com.java.RateSystem.repository;

import com.java.RateSystem.models.Servicerate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ServiceRepository extends JpaRepository<Servicerate, Integer> {
    @Query("SELECT s FROM Servicerate s WHERE s.id = ?1")
    Optional<Servicerate> findByServiceId(Integer id);

    @Query("SELECT s FROM Servicerate s WHERE s.uuid = ?1")
    Optional<Servicerate> findByUUId(UUID uuid);
}
