package com.psykey.psykeyapirest.repository;

import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.ClinicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalHistoryRepository extends JpaRepository<ClinicalHistory, Long> {
    ClinicalHistory findClinicalHistoryByPatientId(final Long patientId);
}
