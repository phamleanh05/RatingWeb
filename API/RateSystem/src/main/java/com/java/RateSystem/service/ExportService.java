package com.java.RateSystem.service;

import com.java.RateSystem.models.ExportData;
import com.java.RateSystem.models.Servicerate;
import com.java.RateSystem.repository.ExportRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

@Service
@Transactional
public class ExportService {
    @Autowired
    private ExportRepository exportRepository;

    public List<ExportData> findByMonth(@PathVariable Integer month){
        return exportRepository.findByMonth(month);
    }

    public List<ExportData> fetchExportDataInnerJoin(){
        return exportRepository.fetchExportDataInnerJoin(Sort.by("avgscore").ascending());
    }

    public ExportData save(@RequestBody ExportData newExport) { return exportRepository.save(newExport);}

    //Export
    private static final Logger log = getLogger(ExportService.class);
    public ExportService(ExportRepository exportRepository) {
        this.exportRepository = exportRepository;
    }

    public void writeEmployeesToCsv(Writer writer) {
        List<ExportData> exportDataS = exportRepository.fetchExportDataInnerJoin(Sort.by("avgscore").ascending());
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (ExportData exportData : exportDataS) {
                csvPrinter.printRecord(exportData.getAvgscore(), exportData.getName(), exportData.getDescription(), exportData.getDate());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }
}
