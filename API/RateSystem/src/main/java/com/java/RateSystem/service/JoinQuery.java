package com.java.RateSystem.service;

import com.java.RateSystem.models.ExportData;
import com.java.RateSystem.repository.ExportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JoinQuery {
    @Autowired
    private ExportRepository exportRepository;


    public List<ExportData> listAll(){
        return exportRepository.findAll(Sort.by("avgscore").ascending());
    }

    public List<ExportData> updateExport() {
        return exportRepository.fetchExportDataInnerJoin(Sort.by("avgscore").ascending());
    }

}
