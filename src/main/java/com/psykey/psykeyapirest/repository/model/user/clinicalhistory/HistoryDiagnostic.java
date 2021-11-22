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

@Entity
@Table(name = "history_diagnostic")
public class HistoryDiagnostic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "result", length = 500)
	private String result;

	@Column(name = "diagnosis", length = 5000)
	private String diagnosis;

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

	public String getResult() {
		return this.result;
	}

	public void setResult(final String result) {
		this.result = result;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(final String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public ClinicalHistory getClinicalHistory() {
		return this.clinicalHistory;
	}

	public void setClinicalHistory(final ClinicalHistory clinicalHistory) {
		this.clinicalHistory = clinicalHistory;
	}
}
