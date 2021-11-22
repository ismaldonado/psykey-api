package com.psykey.psykeyapirest.repository.model.user.clinicalhistory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "history_medicine")
public class HistoryMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dose")
    private String dose;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "comment", length = 5000)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_history_id", referencedColumnName = "id", nullable = false)
    private ClinicalHistory clinicalHistory;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDose() {
        return this.dose;
    }

    public void setDose(final String dose) {
        this.dose = dose;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(final LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(final LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public ClinicalHistory getClinicalHistory() {
        return this.clinicalHistory;
    }

    public void setClinicalHistory(final ClinicalHistory clinicalHistory) {
        this.clinicalHistory = clinicalHistory;
    }
}
