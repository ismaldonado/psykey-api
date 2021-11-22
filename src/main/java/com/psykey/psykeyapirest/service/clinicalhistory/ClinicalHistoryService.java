package com.psykey.psykeyapirest.service.clinicalhistory;

import com.psykey.psykeyapirest.model.converter.clinicalhistory.request.ClinicalHistoryRequestToClinicalHistoryConverter;
import com.psykey.psykeyapirest.model.converter.clinicalhistory.response.ClinicalHistoryToClinicalHistoryResponseConverter;
import com.psykey.psykeyapirest.model.user.clinicalhistory.ClinicalHistoryRR;
import com.psykey.psykeyapirest.repository.ClinicalHistoryRepository;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.ClinicalHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClinicalHistoryService {
    private final ClinicalHistoryRepository clinicalHistoryRepository;
    private final ClinicalHistoryToClinicalHistoryResponseConverter clinicalHistoryResponseConverter;
    private final ClinicalHistoryRequestToClinicalHistoryConverter clinicalHistoryRequestConverter;

    @Autowired
    ClinicalHistoryService(final ClinicalHistoryRepository clinicalHistoryRepository,
                           final ClinicalHistoryToClinicalHistoryResponseConverter clinicalHistoryResponseConverter,
                           final ClinicalHistoryRequestToClinicalHistoryConverter clinicalHistoryRequestConverter) {
        this.clinicalHistoryRepository = clinicalHistoryRepository;
        this.clinicalHistoryResponseConverter = clinicalHistoryResponseConverter;
        this.clinicalHistoryRequestConverter = clinicalHistoryRequestConverter;
    }

    public ClinicalHistoryRR getClinicalHistoryResponse(final Long patientId) {
        final ClinicalHistory clinicalHistory = this.getClinicalHistory(patientId);
        if (Objects.nonNull(clinicalHistory)) {
            return this.clinicalHistoryResponseConverter.convert(clinicalHistory);
        } else {
            return null;
        }
    }

    public ClinicalHistoryRR saveClinicalHistory(final ClinicalHistoryRR clinicalHistoryRequest) {
        final ClinicalHistory clinicalHistory = this.clinicalHistoryRequestConverter.convert(clinicalHistoryRequest);
        return this.clinicalHistoryResponseConverter.convert(this.saveClinicalHistory(clinicalHistory));
    }

    private ClinicalHistory getClinicalHistory(final Long patientId) {
        return this.clinicalHistoryRepository.findClinicalHistoryByPatientId(patientId);
    }

    private ClinicalHistory saveClinicalHistory(final ClinicalHistory clinicalHistory) {
        return this.clinicalHistoryRepository.save(clinicalHistory);
    }
}
