package com.psykey.psykeyapirest.model.user.clinicalhistory;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.time.LocalDate;

@Value
@Builder
@Jacksonized
public class MedicineRR implements Serializable {
    private static final long serialVersionUID = -1134643991262141558L;
    Long id;
    Long clinicalHistoryId;
    String name;
    String dose;
    LocalDate startDate;
    LocalDate endDate;
    String comments;
}
