package com.psykey.psykeyapirest.service.clinicalhistory;

import com.psykey.psykeyapirest.model.converter.clinicalhistory.request.DiagnosticRequestToHistoryDiagnosticConverter;
import com.psykey.psykeyapirest.model.converter.clinicalhistory.response.HistoryDiagnosticToDiagnosticResponseConverter;
import com.psykey.psykeyapirest.model.user.clinicalhistory.DiagnosticRR;
import com.psykey.psykeyapirest.repository.HistoryDiagnosticRepository;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryDiagnostic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticService {
    private final HistoryDiagnosticRepository historyDiagnosticRepository;
    private final HistoryDiagnosticToDiagnosticResponseConverter diagnosticResponseConverter;
    private final DiagnosticRequestToHistoryDiagnosticConverter diagnosticRequestConverter;

    @Autowired
    DiagnosticService(final HistoryDiagnosticRepository historyDiagnosticRepository,
                      final HistoryDiagnosticToDiagnosticResponseConverter diagnosticResponseConverter,
                      final DiagnosticRequestToHistoryDiagnosticConverter diagnosticRequestConverter) {
        this.historyDiagnosticRepository = historyDiagnosticRepository;
        this.diagnosticRequestConverter = diagnosticRequestConverter;
        this.diagnosticResponseConverter = diagnosticResponseConverter;
    }

    public DiagnosticRR saveDiagnostic(final DiagnosticRR diagnosticRequest) {
        final HistoryDiagnostic historyDiagnostic = this.diagnosticRequestConverter.convert(diagnosticRequest);
        return this.diagnosticResponseConverter.convert(this.saveDiagnostic(historyDiagnostic));
    }

    private HistoryDiagnostic saveDiagnostic(final HistoryDiagnostic historyDiagnostic) {
        return this.historyDiagnosticRepository.save(historyDiagnostic);
    }
}
