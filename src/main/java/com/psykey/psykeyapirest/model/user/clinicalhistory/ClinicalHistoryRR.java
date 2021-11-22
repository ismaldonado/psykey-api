package com.psykey.psykeyapirest.model.user.clinicalhistory;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.util.List;

@Value
@Builder
@Jacksonized
public class ClinicalHistoryRR implements Serializable {
    private static final long serialVersionUID = 192839932849537641L;
    Long id;
    Long patientId;
    Long employeeId;
    AdditionalInfoRR additionalInfoRR;
    List<MedicineRR> medicineRRList;
    List<DiagnosticRR> diagnosticRRList;
    List<ReportRR> reportRRList;
    List<TreatmentRR> treatmentRRList;
}
