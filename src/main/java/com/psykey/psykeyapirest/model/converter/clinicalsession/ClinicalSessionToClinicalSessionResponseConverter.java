package com.psykey.psykeyapirest.model.converter.clinicalsession;

import com.psykey.psykeyapirest.model.user.clinicalsession.ClinicalSessionRR;
import com.psykey.psykeyapirest.repository.model.user.ClinicalSession;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClinicalSessionToClinicalSessionResponseConverter implements Converter<ClinicalSession, ClinicalSessionRR> {
    @Override
    public ClinicalSessionRR convert(final ClinicalSession clinicalSession) {
        return ClinicalSessionRR.builder()
                .id(clinicalSession.getId())
                .employeeId(clinicalSession.getEmployeeId())
                .patientId(clinicalSession.getPatientId())
                .name(clinicalSession.getName())
                .date(clinicalSession.getDate())
                .description(clinicalSession.getDescription())
                .build();
    }
}
