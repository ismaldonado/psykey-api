package com.psykey.psykeyapirest.repository;

import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryDiagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryDiagnosticRepository extends JpaRepository<HistoryDiagnostic, Long> {

}
