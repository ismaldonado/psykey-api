package com.psykey.psykeyapirest.model.converter.user;

import com.psykey.psykeyapirest.model.user.UserCreateRequest;
import com.psykey.psykeyapirest.repository.model.user.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserCreateRequestToUserConverter implements Converter<UserCreateRequest, User> {
    @Override
    public User convert(final UserCreateRequest userCreateRequest) {
        final User user = new User();
        user.setId(userCreateRequest.getId());
        user.setDni(userCreateRequest.getDni());
        user.setName(userCreateRequest.getName());
        user.setSurname(userCreateRequest.getSurname());
        user.setPhone(userCreateRequest.getPhone());
        user.setAddress(userCreateRequest.getAddress());
        user.setCity(userCreateRequest.getCity());
        user.setProvince(userCreateRequest.getProvince());
        user.setPostalCode(userCreateRequest.getPostalCode());
        user.setBirthdate(userCreateRequest.getBirthdate());
        user.setUserType(userCreateRequest.getUserType());
        user.setTherapyType(userCreateRequest.getTherapyType());
        user.setReason(userCreateRequest.getReason());
        user.setActive(this.getActive(userCreateRequest.getActive()));
        user.setClient(
                userCreateRequest.getUserType().equals("patient") && Objects.nonNull(userCreateRequest.getClient())
                        ? this.buildUserClient(userCreateRequest.getClient())
                        : null);
        user.setPatientRelationship(userCreateRequest.getPatientRelationship());
        user.setEmployee(this.getEmployee(userCreateRequest.getEmployeeId()));
        user.setUsername(userCreateRequest.getDni());

        return user;
    }

    public boolean getActive(final Boolean isActive) {
        return isActive == null || isActive;
    }

    public User buildUserClient(final UserCreateRequest clientCreateRequest) {
        return Objects.nonNull(clientCreateRequest) ? this.convert(clientCreateRequest) : null;
    }

    private User getEmployee(final Long id) {
        final User employee = new User();
        if (Objects.nonNull(id)) {
            employee.setId(id);
            return employee;
        }
        return null;
    }
}
