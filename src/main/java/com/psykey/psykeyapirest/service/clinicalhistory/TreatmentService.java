package com.psykey.psykeyapirest.service.clinicalhistory;

import com.psykey.psykeyapirest.model.converter.clinicalhistory.request.TreatmentRequestToHistoryTreatmentConverter;
import com.psykey.psykeyapirest.model.converter.clinicalhistory.response.TreatmentToTreatmentResponseConverter;
import com.psykey.psykeyapirest.model.user.clinicalhistory.TreatmentRR;
import com.psykey.psykeyapirest.repository.HistoryTreatmentRepository;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryTreatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreatmentService {
    private final HistoryTreatmentRepository historyTreatmentRepository;
    private final TreatmentToTreatmentResponseConverter treatmentResponseConverter;
    private final TreatmentRequestToHistoryTreatmentConverter treatmentRequestConverter;

    @Autowired
    TreatmentService(final HistoryTreatmentRepository historyTreatmentRepository,
                     final TreatmentToTreatmentResponseConverter treatmentResponseConverter,
                     final TreatmentRequestToHistoryTreatmentConverter treatmentRequestConverter) {
        this.historyTreatmentRepository = historyTreatmentRepository;
        this.treatmentRequestConverter = treatmentRequestConverter;
        this.treatmentResponseConverter = treatmentResponseConverter;
    }

    public TreatmentRR saveTreatment(final TreatmentRR treatmentRequest) {
        final HistoryTreatment historyTreatment = this.treatmentRequestConverter.convert(treatmentRequest);
        return this.treatmentResponseConverter.convert(this.saveHistoryTreatment(historyTreatment));
    }

    private HistoryTreatment saveHistoryTreatment(final HistoryTreatment historyTreatment) {
        return this.historyTreatmentRepository.save(historyTreatment);
    }
}
