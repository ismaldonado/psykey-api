package com.psykey.psykeyapirest.model.converter.clinicalhistory.response;

import com.psykey.psykeyapirest.model.user.clinicalhistory.TreatmentRR;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryTreatment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TreatmentToTreatmentResponseConverter implements Converter<HistoryTreatment, TreatmentRR> {
    @Override
    public TreatmentRR convert(final HistoryTreatment historyTreatment) {
        return TreatmentRR.builder()
                .id(historyTreatment.getId())
                .title(historyTreatment.getTitle())
                .description(historyTreatment.getDescription())
                .startDate(historyTreatment.getStartDate())
                .endDate(historyTreatment.getEndDate())
                .build();
    }
}
