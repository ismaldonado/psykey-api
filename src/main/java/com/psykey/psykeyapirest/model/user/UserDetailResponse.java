package com.psykey.psykeyapirest.model.user;

import com.psykey.psykeyapirest.model.user.clinicalhistory.ClinicalHistoryRR;
import com.psykey.psykeyapirest.model.user.clinicalsession.ClinicalSessionRR;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Value
@Builder
@Jacksonized
public class UserDetailResponse implements Serializable {
	private static final long serialVersionUID = 3688117643078736941L;
	Long id;
	String dni;
    String name;
    String surname;
    String phone;
    String address;
    String city;
    String province;
    String postalCode;
    LocalDate birthdate;
    String userType;
    String therapyType;
    String reason;
    UserDetailResponse client;
    String patientRelationship;
    String employeeUsername;
    Long employeeId;
    ClinicalHistoryRR clinicalHistoryResponse;
    List<ClinicalSessionRR> clinicalSessionResponseList;
}
