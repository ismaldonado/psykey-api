package com.psykey.psykeyapirest.model.user.clinicalhistory;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.time.LocalDate;

@Value
@Builder
@Jacksonized
public class ReportRR implements Serializable {
    private static final long serialVersionUID = -1099725046330591631L;
    Long id;
    Long clinicalHistoryId;
    LocalDate date;
    String description;
}

