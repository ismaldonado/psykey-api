package com.psykey.psykeyapirest.controller;

import com.psykey.psykeyapirest.model.user.EmployeeResponse;
import com.psykey.psykeyapirest.model.user.SearchRequest;
import com.psykey.psykeyapirest.model.user.SearchResponse;
import com.psykey.psykeyapirest.model.user.UserCreateRequest;
import com.psykey.psykeyapirest.model.user.UserDetailResponse;
import com.psykey.psykeyapirest.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@PreAuthorize("authenticated")
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long createUser(@RequestBody final UserCreateRequest userCreateRequest) {
        return this.userService.createUser(userCreateRequest);
    }

    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<SearchResponse> searchUsers(@RequestBody final SearchRequest searchRequest) {
        return this.userService.getUsersFiltered(searchRequest, this.getAuthenticationName());
    }

    @GetMapping(value = "/user-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDetailResponse getUser(@RequestParam final Long id) {
        return this.userService.getUser(id, this.getAuthenticationName());
    }
    
    @GetMapping(value = "/employees-by-therapy", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeResponse> getEmployees(@RequestParam final String therapyType) {
        return this.userService.getEmployeesByTherapyType(therapyType);
    }

    private String getAuthenticationName() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Objects.nonNull(authentication) ? (String) authentication.getPrincipal() : null;
    }
}
