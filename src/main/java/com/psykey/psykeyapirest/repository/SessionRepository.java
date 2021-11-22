package com.psykey.psykeyapirest.repository;

import com.psykey.psykeyapirest.repository.model.user.ClinicalSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<ClinicalSession, Long> {
    List<ClinicalSession> findSessionByPatientId(final Long patientId);
}
