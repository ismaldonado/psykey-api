package com.psykey.psykeyapirest.model.converter.clinicalhistory.request;

import com.psykey.psykeyapirest.model.user.clinicalhistory.ClinicalHistoryRR;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.ClinicalHistory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClinicalHistoryRequestToClinicalHistoryConverter implements Converter<ClinicalHistoryRR, ClinicalHistory> {
    @Override
    public ClinicalHistory convert(final ClinicalHistoryRR clinicalHistoryRR) {
        final ClinicalHistory clinicalHistory = new ClinicalHistory();
        clinicalHistory.setId(clinicalHistoryRR.getId());
        clinicalHistory.setEmploymentInfo(clinicalHistoryRR.getAdditionalInfoRR().getEmploymentInfo());
        clinicalHistory.setFamilyInfo(clinicalHistoryRR.getAdditionalInfoRR().getFamilyInfo());
        clinicalHistory.setSocialInfo(clinicalHistoryRR.getAdditionalInfoRR().getSocialInfo());
        clinicalHistory.setPatientId(clinicalHistoryRR.getPatientId());
        clinicalHistory.setEmployeeId(clinicalHistoryRR.getEmployeeId());
        return clinicalHistory;
    }
}
