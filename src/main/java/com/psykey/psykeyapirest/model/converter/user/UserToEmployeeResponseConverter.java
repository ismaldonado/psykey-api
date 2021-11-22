package com.psykey.psykeyapirest.model.converter.user;

import com.psykey.psykeyapirest.model.user.EmployeeResponse;
import com.psykey.psykeyapirest.repository.model.user.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserToEmployeeResponseConverter implements Converter<User, EmployeeResponse> {

	@Override
	public EmployeeResponse convert(final User user) {
		final EmployeeResponse employeeResponse = new EmployeeResponse(user.getId(), this.getUserFullName(user));
		return employeeResponse;
	}

	private String getUserFullName(final User user) {
		return Objects.nonNull(user) ? user.getName().concat(" ").concat(user.getSurname()) : null;
	}
}
