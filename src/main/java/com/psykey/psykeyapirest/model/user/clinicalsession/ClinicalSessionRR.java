package com.psykey.psykeyapirest.model.user.clinicalsession;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Value
@Builder
@Jacksonized
public class ClinicalSessionRR {
    Long id;
    Long patientId;
    Long employeeId;
    LocalDate date;
    String name;
    String description;
}
