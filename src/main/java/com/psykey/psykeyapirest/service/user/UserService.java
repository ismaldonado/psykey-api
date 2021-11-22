package com.psykey.psykeyapirest.service.user;

import com.psykey.psykeyapirest.model.converter.user.UserCreateRequestToUserConverter;
import com.psykey.psykeyapirest.model.converter.user.UserToEmployeeResponseConverter;
import com.psykey.psykeyapirest.model.converter.user.UserToSearchResponseConverter;
import com.psykey.psykeyapirest.model.converter.user.UserToUserDetailResponseConverter;
import com.psykey.psykeyapirest.model.user.EmployeeResponse;
import com.psykey.psykeyapirest.model.user.SearchRequest;
import com.psykey.psykeyapirest.model.user.SearchResponse;
import com.psykey.psykeyapirest.model.user.UserCreateRequest;
import com.psykey.psykeyapirest.model.user.UserDetailResponse;
import com.psykey.psykeyapirest.repository.model.user.User;
import com.psykey.psykeyapirest.service.access.AccessService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserPersistenceService userPersistenceService;
    private final UserToSearchResponseConverter searchResponseConverter;
    private final UserToUserDetailResponseConverter userToUserDetailResponseConverter;
    private final UserCreateRequestToUserConverter userCreateRequestToUserConverter;
    private final AccessService accessService;
    private final UserToEmployeeResponseConverter userToEmployeeResponseConverter;

    @Autowired
    UserService(final UserPersistenceService userPersistenceService,
                final UserToSearchResponseConverter searchResponseConverter,
                final UserToUserDetailResponseConverter userToUserDetailResponseConverter,
                final UserCreateRequestToUserConverter userCreateRequestToUserConverter,
                final AccessService accessService,
                final UserToEmployeeResponseConverter userToEmployeeResponseConverter) {
        this.userPersistenceService = userPersistenceService;
        this.searchResponseConverter = searchResponseConverter;
        this.userToUserDetailResponseConverter = userToUserDetailResponseConverter;
        this.userCreateRequestToUserConverter = userCreateRequestToUserConverter;
        this.accessService = accessService;
        this.userToEmployeeResponseConverter = userToEmployeeResponseConverter;
    }

    public Long createUser(final UserCreateRequest userCreateRequest) {
        final User user = this.saveUser(this.userCreateRequestToUserConverter.convert(userCreateRequest));
        if (Objects.nonNull(user) && Objects.isNull(userCreateRequest.getId())) {
            this.createUserCredentials(user.getDni(), this.getUserFullName(user), user.getUserType());
        }
        return user.getId(); 
    }

    public List<SearchResponse> getUsersFiltered(final SearchRequest searchRequest, final String userLogged) {
        return this.findUsersFiltered(searchRequest, userLogged).stream().map(this.searchResponseConverter::convert)
                .collect(Collectors.toList());
    }

    public UserDetailResponse getUser(final Long id, final String userLogged) {
        return this.userToUserDetailResponseConverter.convert(this.findUserById(id).orElseThrow(), userLogged);
    }

    public List<EmployeeResponse> getEmployeesByTherapyType(final String therapyType) {
        return this.userPersistenceService.findUserByUserTypeAndTherapyType(therapyType).stream()
                .map(user -> this.userToEmployeeResponseConverter.convert(user)).collect(Collectors.toList());
    }

    private User saveUser(final User user) {
        return this.userPersistenceService.saveUser(user);
    }

    private void createUserCredentials(final String username, final String fullName, final String userType) {
        this.accessService.saveUser(null, username, fullName, userType);
    }

    private List<User> findUsersFiltered(final SearchRequest searchRequest, final String userLogged) {
        return this.userPersistenceService.findAllByFilter(searchRequest, this.checkUserLogged(userLogged));
    }

    private Optional<User> findUserById(final Long id) {
        return this.userPersistenceService.findUserById(id);
    }

    private String checkUserLogged(final String userLogged) {
        if (ObjectUtils.isEmpty(userLogged) || StringUtils.containsAnyIgnoreCase(userLogged, "admin", "secretary")) {
            return null;
        }
        return userLogged;
    }

    private String getUserFullName(final User user) {
        return Objects.nonNull(user) ? user.getName().concat(" ").concat(user.getSurname()) : null;
    }
}
