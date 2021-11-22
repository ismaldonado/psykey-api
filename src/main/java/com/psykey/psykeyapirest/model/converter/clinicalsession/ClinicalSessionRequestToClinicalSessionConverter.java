package com.psykey.psykeyapirest.model.converter.clinicalsession;

import com.psykey.psykeyapirest.model.user.clinicalsession.ClinicalSessionRR;
import com.psykey.psykeyapirest.repository.model.user.ClinicalSession;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClinicalSessionRequestToClinicalSessionConverter implements Converter<ClinicalSessionRR, ClinicalSession> {
    @Override
    public ClinicalSession convert(final ClinicalSessionRR clinicalSessionRR) {
        final ClinicalSession clinicalSession = new ClinicalSession();
        clinicalSession.setId(clinicalSessionRR.getId());
        clinicalSession.setEmployeeId(clinicalSessionRR.getEmployeeId());
        clinicalSession.setPatientId(clinicalSessionRR.getPatientId());
        clinicalSession.setName(clinicalSessionRR.getName());
        clinicalSession.setDate(clinicalSessionRR.getDate());
        clinicalSession.setDescription(clinicalSessionRR.getDescription());
        return clinicalSession;
    }
}
