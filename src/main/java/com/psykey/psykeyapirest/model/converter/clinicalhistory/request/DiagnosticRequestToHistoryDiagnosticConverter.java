package com.psykey.psykeyapirest.model.converter.clinicalhistory.request;

import com.psykey.psykeyapirest.model.user.clinicalhistory.DiagnosticRR;
import com.psykey.psykeyapirest.repository.ClinicalHistoryRepository;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.ClinicalHistory;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryDiagnostic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DiagnosticRequestToHistoryDiagnosticConverter implements Converter<DiagnosticRR, HistoryDiagnostic> {
    private final ClinicalHistoryRepository clinicalHistoryRepository;

    @Autowired
    DiagnosticRequestToHistoryDiagnosticConverter(final ClinicalHistoryRepository clinicalHistoryRepository) {
        this.clinicalHistoryRepository = clinicalHistoryRepository;
    }

    @Override
    public HistoryDiagnostic convert(final DiagnosticRR diagnosticRR) {
        final Optional<ClinicalHistory> clinicalHistory = this.clinicalHistoryRepository.findById(diagnosticRR.getClinicalHistoryId());
        final HistoryDiagnostic historyDiagnostic = new HistoryDiagnostic();
        historyDiagnostic.setId(diagnosticRR.getId());
        historyDiagnostic.setName(diagnosticRR.getName());
        historyDiagnostic.setResult(diagnosticRR.getResults());
        historyDiagnostic.setDiagnosis(diagnosticRR.getDiagnosis());
        historyDiagnostic.setClinicalHistory(clinicalHistory.orElse(null));
        return historyDiagnostic;
    }
}
