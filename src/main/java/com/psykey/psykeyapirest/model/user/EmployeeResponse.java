package com.psykey.psykeyapirest.model.user;

import java.io.Serializable;

import lombok.Value;

@Value
public class EmployeeResponse implements Serializable {

	private static final long serialVersionUID = 6405591199072336591L;
	Long id;
	String employeeFullName;
}
