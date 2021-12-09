package com.psykey.psykeyapirest.model.user;

import java.io.Serializable;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class SearchResponse implements Serializable {
	private static final long serialVersionUID = -6074210176290395190L;
	Long id;
	String dni;
	String name;
	String surname;
	String userType;
	String therapyType;
	String clientFullName;
	String employeeFullName;

}
