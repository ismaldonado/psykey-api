package com.psykey.psykeyapirest.repository.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "clinical_session")
public class ClinicalSession {
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
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 5000)
    private String description;

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

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
