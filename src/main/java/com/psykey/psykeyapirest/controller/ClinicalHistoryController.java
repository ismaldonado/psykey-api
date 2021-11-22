package com.psykey.psykeyapirest.controller;

import com.psykey.psykeyapirest.model.user.clinicalhistory.ClinicalHistoryRR;
import com.psykey.psykeyapirest.model.user.clinicalhistory.DiagnosticRR;
import com.psykey.psykeyapirest.model.user.clinicalhistory.MedicineRR;
import com.psykey.psykeyapirest.model.user.clinicalhistory.ReportRR;
import com.psykey.psykeyapirest.model.user.clinicalhistory.TreatmentRR;
import com.psykey.psykeyapirest.service.clinicalhistory.ClinicalHistoryService;
import com.psykey.psykeyapirest.service.clinicalhistory.DiagnosticService;
import com.psykey.psykeyapirest.service.clinicalhistory.MedicineService;
import com.psykey.psykeyapirest.service.clinicalhistory.ReportService;
import com.psykey.psykeyapirest.service.clinicalhistory.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("authenticated")
@RestController
@RequestMapping("/api/clinical-history")
public class ClinicalHistoryController {
    private final ClinicalHistoryService clinicalHistoryService;
    private final DiagnosticService diagnosticService;
    private final MedicineService medicineService;
    private final ReportService reportService;
    private final TreatmentService treatmentService;

    @Autowired
    ClinicalHistoryController(final ClinicalHistoryService clinicalHistoryService,
                              final DiagnosticService diagnosticService,
                              final MedicineService medicineService,
                              final ReportService reportService,
                              final TreatmentService treatmentService) {
        this.clinicalHistoryService = clinicalHistoryService;
        this.diagnosticService = diagnosticService;
        this.medicineService = medicineService;
        this.reportService = reportService;
        this.treatmentService = treatmentService;
    }

    @PostMapping(value = "/save-clinical-history")
    public ClinicalHistoryRR saveClinicalHistory(@RequestBody final ClinicalHistoryRR clinicalHistoryRequest) {
        return this.clinicalHistoryService.saveClinicalHistory(clinicalHistoryRequest);
    }

    @PostMapping(value = "/save-diagnostic")
    public DiagnosticRR saveDiagnostic(@RequestBody final DiagnosticRR diagnosticRequest) {
        return this.diagnosticService.saveDiagnostic(diagnosticRequest);
    }

    @PostMapping(value = "/save-medicine")
    public MedicineRR saveMedicine(@RequestBody final MedicineRR medicineRequest) {
        return this.medicineService.saveMedicine(medicineRequest);
    }

    @PostMapping(value = "/save-report")
    public ReportRR saveReport(@RequestBody final ReportRR reportRequest) {
        return this.reportService.saveReport(reportRequest);
    }

    @PostMapping(value = "/save-treatment")
    public TreatmentRR saveTreatment(@RequestBody final TreatmentRR treatmentRequest) {
        return this.treatmentService.saveTreatment(treatmentRequest);
    }
}
