package com.java.RateSystem.repository;

import com.java.RateSystem.models.ExportData;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExportRepository extends JpaRepository<ExportData, Integer> {
    @Query("SELECT new com.java.RateSystem.models.ExportData(s.name, s.description, AVG(r.point), r.date) " +
            "FROM Servicerate s INNER JOIN Rating r ON s.id = r.serviceid GROUP BY s.name,s.description,r.date, s.avgscore")
    List<ExportData> fetchExportDataInnerJoin(Sort sort);

}
