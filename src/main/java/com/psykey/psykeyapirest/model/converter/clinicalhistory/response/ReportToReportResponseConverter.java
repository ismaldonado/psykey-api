package com.psykey.psykeyapirest.model.converter.clinicalhistory.response;

import com.psykey.psykeyapirest.model.user.clinicalhistory.ReportRR;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryReport;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReportToReportResponseConverter implements Converter<HistoryReport, ReportRR> {
    @Override
    public ReportRR convert(final HistoryReport historyReport) {
        return ReportRR.builder()
                .id(historyReport.getId())
                .date(historyReport.getDate())
                .description(historyReport.getDescription())
                .build();
    }
}
