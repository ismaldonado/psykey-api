package com.psykey.psykeyapirest.repository;

import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryReportRepository extends JpaRepository<HistoryReport, Long> {

}
