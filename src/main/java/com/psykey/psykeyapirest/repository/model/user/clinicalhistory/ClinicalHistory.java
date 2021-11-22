package com.psykey.psykeyapirest.repository.model.user.clinicalhistory;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "clinical_history")
public class ClinicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @NotNull
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @NotNull
    @Column(name = "social_info", length = 5000, nullable = false)
    private String socialInfo;

    @NotNull
    @Column(name = "family_info", length = 5000, nullable = false)
    private String familyInfo;

    @NotNull
    @Column(name = "employment_info", length = 5000, nullable = false)
    private String employmentInfo;

    @OneToMany(mappedBy = "clinicalHistory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HistoryMedicine> historyMedicine;

    @OneToMany(mappedBy = "clinicalHistory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HistoryDiagnostic> historyDiagnostic;

    @OneToMany(mappedBy = "clinicalHistory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HistoryReport> historyReport;

    @OneToMany(mappedBy = "clinicalHistory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HistoryTreatment> historyTreatment;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return this.patientId;
    }

    public void setPatientId(final Long patientId) {
        this.patientId = patientId;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(final Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getSocialInfo() {
        return this.socialInfo;
    }

    public void setSocialInfo(final String socialInfo) {
        this.socialInfo = socialInfo;
    }

    public String getFamilyInfo() {
        return this.familyInfo;
    }

    public void setFamilyInfo(final String familyInfo) {
        this.familyInfo = familyInfo;
    }

    public String getEmploymentInfo() {
        return this.employmentInfo;
    }

    public void setEmploymentInfo(final String employmentInfo) {
        this.employmentInfo = employmentInfo;
    }

    public List<HistoryMedicine> getHistoryMedicine() {
        return this.historyMedicine;
    }

    public void setHistoryMedicine(final List<HistoryMedicine> historyMedicine) {
        this.historyMedicine = historyMedicine;
    }

    public List<HistoryDiagnostic> getHistoryDiagnostic() {
        return this.historyDiagnostic;
    }

    public void setHistoryDiagnostic(final List<HistoryDiagnostic> historyDiagnostic) {
        this.historyDiagnostic = historyDiagnostic;
    }

    public List<HistoryReport> getHistoryReport() {
        return this.historyReport;
    }

    public void setHistoryReport(final List<HistoryReport> historyReport) {
        this.historyReport = historyReport;
    }

    public List<HistoryTreatment> getHistoryTreatment() {
        return this.historyTreatment;
    }

    public void setHistoryTreatment(final List<HistoryTreatment> historyTreatment) {
        this.historyTreatment = historyTreatment;
    }
}
