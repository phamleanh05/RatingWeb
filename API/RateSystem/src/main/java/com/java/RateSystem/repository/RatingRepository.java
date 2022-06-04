package com.java.RateSystem.repository;

import com.java.RateSystem.models.ExportData;
import com.java.RateSystem.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<Rating, UUID> {
    @Query("SELECT s FROM Rating s WHERE s.id = ?1")
    Optional<Rating> findById(Integer id);

    @Query("SELECT s FROM Rating s WHERE s.uuid = ?1")
    Optional<Rating> findByUUId(UUID uuid);

    @Query("SELECT s FROM Rating s WHERE s.serviceid = ?1")
    List<Rating> findByServiceId(Integer serviceid);

    @Query("SELECT new com.java.RateSystem.models.ExportData(s.name, s.description, AVG(r.point), r.date) " +
            "FROM Servicerate s INNER JOIN Rating r ON s.id = r.serviceid GROUP BY s.name,s.description,r.date")
    List<ExportData> fetchExportDataInnerJoin();

}
