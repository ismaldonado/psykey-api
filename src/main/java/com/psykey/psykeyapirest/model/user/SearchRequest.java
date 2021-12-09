package com.psykey.psykeyapirest.model.user;

import java.io.Serializable;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class SearchRequest implements Serializable {
	private static final long serialVersionUID = 3770361859605193997L;
	String dni;
	String name;
	String surname;
	String userType;
	String therapyType;
}
