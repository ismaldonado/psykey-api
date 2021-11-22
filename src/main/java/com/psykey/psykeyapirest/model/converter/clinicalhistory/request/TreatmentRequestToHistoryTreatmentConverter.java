package com.psykey.psykeyapirest.model.converter.clinicalhistory.request;

import com.psykey.psykeyapirest.model.user.clinicalhistory.TreatmentRR;
import com.psykey.psykeyapirest.repository.ClinicalHistoryRepository;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.ClinicalHistory;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryTreatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TreatmentRequestToHistoryTreatmentConverter implements Converter<TreatmentRR, HistoryTreatment> {
    private final ClinicalHistoryRepository clinicalHistoryRepository;

    @Autowired
    TreatmentRequestToHistoryTreatmentConverter(final ClinicalHistoryRepository clinicalHistoryRepository) {
        this.clinicalHistoryRepository = clinicalHistoryRepository;
    }

    @Override
    public HistoryTreatment convert(final TreatmentRR treatmentRR) {
        final Optional<ClinicalHistory> clinicalHistory = this.clinicalHistoryRepository.findById(treatmentRR.getClinicalHistoryId());
        final HistoryTreatment historyTreatment = new HistoryTreatment();
        historyTreatment.setId(treatmentRR.getId());
        historyTreatment.setTitle(treatmentRR.getTitle());
        historyTreatment.setDescription(treatmentRR.getDescription());
        historyTreatment.setStartDate(treatmentRR.getStartDate());
        historyTreatment.setEndDate(treatmentRR.getEndDate());
        historyTreatment.setClinicalHistory(clinicalHistory.orElse(null));
        return historyTreatment;
    }
}
