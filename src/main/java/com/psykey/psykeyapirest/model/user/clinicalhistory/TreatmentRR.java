package com.psykey.psykeyapirest.model.user.clinicalhistory;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.time.LocalDate;

@Value
@Builder
@Jacksonized
public class TreatmentRR implements Serializable {
    private static final long serialVersionUID = 8390146978610789916L;
    Long id;
    Long clinicalHistoryId;
    String title;
    String description;
    LocalDate startDate;
    LocalDate endDate;
}
