package com.psykey.psykeyapirest.repository;

import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryMedicineRepository extends JpaRepository<HistoryMedicine, Long> {

}
