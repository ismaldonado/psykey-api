package com.psykey.psykeyapirest.model.converter.clinicalhistory.response;

import com.psykey.psykeyapirest.model.user.clinicalhistory.AdditionalInfoRR;
import com.psykey.psykeyapirest.model.user.clinicalhistory.ClinicalHistoryRR;
import com.psykey.psykeyapirest.model.user.clinicalhistory.DiagnosticRR;
import com.psykey.psykeyapirest.model.user.clinicalhistory.MedicineRR;
import com.psykey.psykeyapirest.model.user.clinicalhistory.ReportRR;
import com.psykey.psykeyapirest.model.user.clinicalhistory.TreatmentRR;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.ClinicalHistory;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryDiagnostic;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryMedicine;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryReport;
import com.psykey.psykeyapirest.repository.model.user.clinicalhistory.HistoryTreatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClinicalHistoryToClinicalHistoryResponseConverter implements Converter<ClinicalHistory, ClinicalHistoryRR> {
    private final HistoryDiagnosticToDiagnosticResponseConverter diagnosticResponseConverter;
    private final HistoryMedicineToMedicineResponseConverter medicineResponseConverter;
    private final ReportToReportResponseConverter reportResponseConverter;
    private final TreatmentToTreatmentResponseConverter treatmentResponseConverter;

    @Autowired
    ClinicalHistoryToClinicalHistoryResponseConverter(
            final HistoryDiagnosticToDiagnosticResponseConverter historyDiagnosticToDiagnosticResponseConverter,
            final HistoryMedicineToMedicineResponseConverter historyMedicineToMedicineResponseConverter,
            final ReportToReportResponseConverter reportToReportResponseConverter,
            final TreatmentToTreatmentResponseConverter treatmentToTreatmentResponseConverter) {
        this.diagnosticResponseConverter = historyDiagnosticToDiagnosticResponseConverter;
        this.medicineResponseConverter = historyMedicineToMedicineResponseConverter;
        this.reportResponseConverter = reportToReportResponseConverter;
        this.treatmentResponseConverter = treatmentToTreatmentResponseConverter;
    }

    @Override
    public ClinicalHistoryRR convert(final ClinicalHistory clinicalHistory) {
        final List<HistoryDiagnostic> historyDiagnosticList = clinicalHistory.getHistoryDiagnostic();
        final List<HistoryMedicine> historyMedicineList = clinicalHistory.getHistoryMedicine();
        final List<HistoryReport> historyReportList = clinicalHistory.getHistoryReport();
        final List<HistoryTreatment> historyTreatmentList = clinicalHistory.getHistoryTreatment();

        return ClinicalHistoryRR.builder()
                .id(clinicalHistory.getId())
                .patientId(clinicalHistory.getPatientId())
                .employeeId(clinicalHistory.getEmployeeId())
                .additionalInfoRR(this.getAdditionalInfoResponse(clinicalHistory))
                .diagnosticRRList(CollectionUtils.isEmpty(historyDiagnosticList)
                        ? null
                        : this.getDiagnosticResponse(historyDiagnosticList))
                .medicineRRList(CollectionUtils.isEmpty(historyMedicineList)
                        ? null
                        : this.getMedicineResponse(historyMedicineList))
                .reportRRList(CollectionUtils.isEmpty(historyReportList)
                        ? null
                        : this.getReportResponse(historyReportList))
                .treatmentRRList(CollectionUtils.isEmpty(historyTreatmentList)
                        ? null
                        : this.getTreatmentResponse(historyTreatmentList))
                .build();
    }

    private AdditionalInfoRR getAdditionalInfoResponse(final ClinicalHistory clinicalHistory) {
        return AdditionalInfoRR.builder()
                .socialInfo(clinicalHistory.getSocialInfo())
                .familyInfo(clinicalHistory.getFamilyInfo())
                .employmentInfo(clinicalHistory.getEmploymentInfo())
                .build();
    }

    private List<DiagnosticRR> getDiagnosticResponse(final List<HistoryDiagnostic> historyDiagnosticList) {
        return historyDiagnosticList.stream()
                .map(historyDiagnostic -> this.diagnosticResponseConverter.convert(historyDiagnostic))
                .collect(Collectors.toList());
    }

    private List<MedicineRR> getMedicineResponse(final List<HistoryMedicine> historyMedicineList) {
        return historyMedicineList.stream()
                .map(historyMedicine -> this.medicineResponseConverter.convert(historyMedicine))
                .collect(Collectors.toList());
    }


    private List<ReportRR> getReportResponse(final List<HistoryReport> historyReportList) {
        return historyReportList.stream()
                .map(historyReport -> this.reportResponseConverter.convert(historyReport))
                .collect(Collectors.toList());
    }

    private List<TreatmentRR> getTreatmentResponse(final List<HistoryTreatment> historyTreatmentList) {
        return historyTreatmentList.stream()
                .map(historyTreatment -> this.treatmentResponseConverter.convert(historyTreatment))
                .collect(Collectors.toList());
    }
}
