package com.psykey.psykeyapirest.model.converter.user;

import com.psykey.psykeyapirest.model.user.SearchResponse;
import com.psykey.psykeyapirest.repository.model.user.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserToSearchResponseConverter implements Converter <User, SearchResponse>{

	@Override
	public SearchResponse convert (final User user) {
		return SearchResponse.builder()
			.id(user.getId())
			.dni(user.getDni())
			.name(user.getName())
			.surname(user.getSurname())
			.userType(user.getUserType())
			.therapyType(user.getTherapyType())
			.clientFullName(this.getUserFullName(user.getClient()))
			.employeeFullName(this.getUserFullName(user.getEmployee()))
			.build();		
		
	}

	private String getUserFullName(final User user) {
		return Objects.nonNull(user)
				? user.getName().concat(" ").concat(user.getSurname())
						: null;
	}
	
	
	
}
