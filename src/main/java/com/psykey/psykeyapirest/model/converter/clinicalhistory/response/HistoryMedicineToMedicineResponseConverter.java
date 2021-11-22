package com.psykey.psykeyapirest.model.converter.clinicalhistory.response;

import com.psykey.psykeyapirest.model.user.clinicalhistory.MedicineRR;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryMedicine;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HistoryMedicineToMedicineResponseConverter implements Converter<HistoryMedicine, MedicineRR> {
    @Override
    public MedicineRR convert(final HistoryMedicine historyMedicine) {
        return MedicineRR.builder()
                .id(historyMedicine.getId())
                .name(historyMedicine.getName())
                .startDate(historyMedicine.getStartDate())
                .endDate(historyMedicine.getEndDate())
                .dose(historyMedicine.getDose())
                .comments(historyMedicine.getComment())
                .build();
    }
}
