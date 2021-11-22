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
@Table(name = "history_report")
public class HistoryReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "description", length = 5000)
    private String description;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_history_id", referencedColumnName = "id", nullable = false)
    private ClinicalHistory clinicalHistory;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public ClinicalHistory getClinicalHistory() {
        return this.clinicalHistory;
    }

    public void setClinicalHistory(final ClinicalHistory clinicalHistory) {
        this.clinicalHistory = clinicalHistory;
    }
}
