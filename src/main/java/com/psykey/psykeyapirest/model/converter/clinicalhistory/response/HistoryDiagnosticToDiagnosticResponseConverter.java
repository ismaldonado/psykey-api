package com.psykey.psykeyapirest.model.converter.clinicalhistory.response;

import com.psykey.psykeyapirest.model.user.clinicalhistory.DiagnosticRR;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryDiagnostic;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HistoryDiagnosticToDiagnosticResponseConverter implements Converter<HistoryDiagnostic, DiagnosticRR> {
    @Override
    public DiagnosticRR convert(final HistoryDiagnostic historyDiagnostic) {
        return DiagnosticRR.builder()
                .id(historyDiagnostic.getId())
                .name(historyDiagnostic.getName())
                .diagnosis(historyDiagnostic.getDiagnosis())
                .results(historyDiagnostic.getResult())
                .build();
    }
}
