package com.psykey.psykeyapirest.service.user;

import com.psykey.psykeyapirest.model.converter.clinicalsession.ClinicalSessionRequestToClinicalSessionConverter;
import com.psykey.psykeyapirest.model.converter.clinicalsession.ClinicalSessionToClinicalSessionResponseConverter;
import com.psykey.psykeyapirest.model.user.clinicalsession.ClinicalSessionRR;
import com.psykey.psykeyapirest.repository.SessionRepository;
import com.psykey.psykeyapirest.repository.model.user.ClinicalSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicalSessionService {
    private final SessionRepository sessionRepository;
    private final ClinicalSessionToClinicalSessionResponseConverter clinicalSessionResponseConverter;
    private final ClinicalSessionRequestToClinicalSessionConverter clinicalSessionConverter;

    @Autowired
    ClinicalSessionService(final SessionRepository sessionRepository,
                           final ClinicalSessionToClinicalSessionResponseConverter clinicalSessionResponseConverter,
                           final ClinicalSessionRequestToClinicalSessionConverter clinicalSessionConverter) {
        this.sessionRepository = sessionRepository;
        this.clinicalSessionResponseConverter = clinicalSessionResponseConverter;
        this.clinicalSessionConverter = clinicalSessionConverter;
    }

    public List<ClinicalSessionRR> getClinicalSessionResponse(final Long patientId) {
        final List<ClinicalSession> clinicalSessionList = this.getSessionList(patientId);
        if (CollectionUtils.isEmpty(clinicalSessionList)) {
            return Collections.emptyList();
        } else {
            return clinicalSessionList.stream()
                    .map(clinicalSession -> this.clinicalSessionResponseConverter.convert(clinicalSession))
                    .collect(Collectors.toList());
        }
    }

    public ClinicalSessionRR saveSession(final ClinicalSessionRR clinicalSessionRR) {
        final ClinicalSession clinicalSession = this.sessionRepository.save(this.clinicalSessionConverter.convert(clinicalSessionRR));
        return this.clinicalSessionResponseConverter.convert(clinicalSession);
    }

    private List<ClinicalSession> getSessionList(final Long patientId) {
        return this.sessionRepository.findSessionByPatientId(patientId);
    }
}
