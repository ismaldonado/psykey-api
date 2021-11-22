package com.psykey.psykeyapirest.model.converter.clinicalhistory.request;

import com.psykey.psykeyapirest.model.user.clinicalhistory.MedicineRR;
import com.psykey.psykeyapirest.repository.ClinicalHistoryRepository;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.ClinicalHistory;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MedicineRequestToHistoryMedicineConverter implements Converter<MedicineRR, HistoryMedicine> {
    private final ClinicalHistoryRepository clinicalHistoryRepository;

    @Autowired
    MedicineRequestToHistoryMedicineConverter(final ClinicalHistoryRepository clinicalHistoryRepository) {
        this.clinicalHistoryRepository = clinicalHistoryRepository;
    }

    @Override
    public HistoryMedicine convert(final MedicineRR medicineRR) {
        final Optional<ClinicalHistory> clinicalHistory = this.clinicalHistoryRepository.findById(medicineRR.getClinicalHistoryId());
        final HistoryMedicine historyMedicine = new HistoryMedicine();
        historyMedicine.setId(medicineRR.getId());
        historyMedicine.setName(medicineRR.getName());
        historyMedicine.setDose(medicineRR.getDose());
        historyMedicine.setStartDate(medicineRR.getStartDate());
        historyMedicine.setEndDate(medicineRR.getEndDate());
        historyMedicine.setComment(medicineRR.getComments());
        historyMedicine.setClinicalHistory(clinicalHistory.orElse(null));
        return historyMedicine;
    }
}
