package com.psykey.psykeyapirest.model.converter.clinicalhistory.request;

import com.psykey.psykeyapirest.model.user.clinicalhistory.ReportRR;
import com.psykey.psykeyapirest.repository.ClinicalHistoryRepository;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.ClinicalHistory;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReportRequestToHistoryReportConverter implements Converter<ReportRR, HistoryReport> {
    private final ClinicalHistoryRepository clinicalHistoryRepository;

    @Autowired
    ReportRequestToHistoryReportConverter(final ClinicalHistoryRepository clinicalHistoryRepository) {
        this.clinicalHistoryRepository = clinicalHistoryRepository;
    }

    @Override
    public HistoryReport convert(final ReportRR reportRR) {
        final Optional<ClinicalHistory> clinicalHistory = this.clinicalHistoryRepository.findById(reportRR.getClinicalHistoryId());
        final HistoryReport historyReport = new HistoryReport();
        historyReport.setId(reportRR.getId());
        historyReport.setDate(reportRR.getDate());
        historyReport.setDescription(reportRR.getDescription());
        historyReport.setClinicalHistory(clinicalHistory.orElse(null));
        return historyReport;
    }
}
