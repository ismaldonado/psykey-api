package com.psykey.psykeyapirest.service.clinicalhistory;

import com.psykey.psykeyapirest.model.converter.clinicalhistory.request.MedicineRequestToHistoryMedicineConverter;
import com.psykey.psykeyapirest.model.converter.clinicalhistory.response.HistoryMedicineToMedicineResponseConverter;
import com.psykey.psykeyapirest.model.user.clinicalhistory.MedicineRR;
import com.psykey.psykeyapirest.repository.HistoryMedicineRepository;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {
    private final HistoryMedicineRepository historyMedicineRepository;
    private final HistoryMedicineToMedicineResponseConverter medicineResponseConverter;
    private final MedicineRequestToHistoryMedicineConverter medicineRequestConverter;

    @Autowired
    MedicineService(final HistoryMedicineRepository historyMedicineRepository,
                    final HistoryMedicineToMedicineResponseConverter medicineResponseConverter,
                    final MedicineRequestToHistoryMedicineConverter medicineRequestConverter) {
        this.historyMedicineRepository = historyMedicineRepository;
        this.medicineRequestConverter = medicineRequestConverter;
        this.medicineResponseConverter = medicineResponseConverter;
    }

    public MedicineRR saveMedicine(final MedicineRR medicineRequest) {
        final HistoryMedicine historyMedicine = this.medicineRequestConverter.convert(medicineRequest);
        return this.medicineResponseConverter.convert(this.saveMedicine(historyMedicine));
    }

    private HistoryMedicine saveMedicine(final HistoryMedicine historyMedicine) {
        return this.historyMedicineRepository.save(historyMedicine);
    }
}
