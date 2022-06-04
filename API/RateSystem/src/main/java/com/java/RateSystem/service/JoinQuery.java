package com.java.RateSystem.service;

import com.java.RateSystem.models.ExportData;
import com.java.RateSystem.repository.RatingRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JoinQuery {
    @Resource
    private RatingRepository ratingRepository;

    public List<ExportData> getDeptEmployeesInnerJoin() {
        List<ExportData> list = ratingRepository.fetchExportDataInnerJoin();
        list.forEach(l -> System.out.println(l));
        return list;
    }
}
