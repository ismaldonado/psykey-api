package com.psykey.psykeyapirest.model.user.clinicalhistory;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Value
@Builder
@Jacksonized
public class DiagnosticRR implements Serializable {
    private static final long serialVersionUID = -5458670810858271989L;
    Long id;
    Long clinicalHistoryId;
    String name;
    String results;
    String diagnosis;
}
