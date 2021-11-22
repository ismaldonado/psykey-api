package com.psykey.psykeyapirest.service.clinicalhistory;

import com.psykey.psykeyapirest.model.converter.clinicalhistory.request.ReportRequestToHistoryReportConverter;
import com.psykey.psykeyapirest.model.converter.clinicalhistory.response.ReportToReportResponseConverter;
import com.psykey.psykeyapirest.model.user.clinicalhistory.ReportRR;
import com.psykey.psykeyapirest.repository.HistoryReportRepository;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final HistoryReportRepository historyReportRepository;
    private final ReportToReportResponseConverter reportResponseConverter;
    private final ReportRequestToHistoryReportConverter reportRequestConverter;

    @Autowired
    ReportService(final HistoryReportRepository historyReportRepository,
                  final ReportToReportResponseConverter reportResponseConverter,
                  final ReportRequestToHistoryReportConverter reportRequestConverter) {
        this.historyReportRepository = historyReportRepository;
        this.reportRequestConverter = reportRequestConverter;
        this.reportResponseConverter = reportResponseConverter;
    }

    public ReportRR saveReport(final ReportRR reportRequest) {
        final HistoryReport historyReport = this.reportRequestConverter.convert(reportRequest);
        return this.reportResponseConverter.convert(this.saveReport(historyReport));
    }

    private HistoryReport saveReport(final HistoryReport historyReport) {
        return this.historyReportRepository.save(historyReport);
    }
}
