package com.psykey.psykeyapirest.model.user;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.time.LocalDate;


@Value
@Builder
@Jacksonized
public class UserCreateRequest implements Serializable {
	private static final long serialVersionUID = -8399152843931971568L;
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
    String patientRelationship;
    Boolean active;
    UserCreateRequest client;
    Long employeeId;
}
