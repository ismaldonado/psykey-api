package com.psykey.psykeyapirest.repository;

import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryTreatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryTreatmentRepository extends JpaRepository<HistoryTreatment, Long> {

}
