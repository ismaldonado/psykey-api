package com.psykey.psykeyapirest.model.user.clinicalhistory;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Value
@Builder
@Jacksonized
public class AdditionalInfoRR implements Serializable {
    private static final long serialVersionUID = -735994324259021595L;
    String socialInfo;
    String familyInfo;
    String employmentInfo;
}
