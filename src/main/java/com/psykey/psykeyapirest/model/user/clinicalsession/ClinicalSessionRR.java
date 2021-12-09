package com.psykey.psykeyapirest.model.user.clinicalsession;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.time.LocalDate;

@Value
@Builder
@Jacksonized
public class ClinicalSessionRR implements Serializable {
	private static final long serialVersionUID = -5922226015644829893L;
	Long id;
    Long patientId;
    Long employeeId;
	LocalDate date;
    String name;
    String description;
}
