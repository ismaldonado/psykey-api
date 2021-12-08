package com.psykey.psykeyapirest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.psykey.psykeyapirest.configuration.NoSecurityConfiguration;
import com.psykey.psykeyapirest.model.user.EmployeeResponse;
import com.psykey.psykeyapirest.model.user.SearchRequest;
import com.psykey.psykeyapirest.model.user.SearchResponse;
import com.psykey.psykeyapirest.model.user.UserCreateRequest;
import com.psykey.psykeyapirest.model.user.UserDetailResponse;
import com.psykey.psykeyapirest.model.user.clinicalhistory.ClinicalHistoryRR;
import com.psykey.psykeyapirest.model.user.clinicalsession.ClinicalSessionRR;
import com.psykey.psykeyapirest.service.user.UserService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = {UserController.class, NoSecurityConfiguration.class})
class UserControllerTest {
    private static final String API_URL = "/api/user";

    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void userController_createUserTest() {
        final UserCreateRequest userCreateRequest = this.buildUserCreateRequest();
        final String content = this.objectMapper.writeValueAsString(userCreateRequest);
        given(this.userService.createUser(userCreateRequest)).willReturn(1L);
        final MvcResult mvcResult = this.mockMvc.perform(post(API_URL.concat("/create"))
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(content))
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertEquals(this.objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Long.class), 1L);
    }

    @Test
    @SneakyThrows
    void userController_searchUsersTest() {
        final SearchRequest searchRequest = this.buildSearchRequest();
        final SearchResponse response = this.buildSearchResponse();
        final String content = this.objectMapper.writeValueAsString(searchRequest);
        given(this.userService.getUsersFiltered(searchRequest, "admin")).willReturn(Collections.singletonList(response));
        this.mockMvc.perform(post(API_URL.concat("/search"))
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(content))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @SneakyThrows
    void userController_getUserTest() {
        final UserDetailResponse response = this.buildUserDetailResponse();
        given(this.userService.getUser(1L, "admin")).willReturn(response);
        this.mockMvc.perform(get(API_URL.concat("/user-by-id"))
                        .param("id", "1")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @SneakyThrows
    void userController_getEmployeesTest() {
        final EmployeeResponse response = this.buildEmployeeResponse();
        given(this.userService.getEmployeesByTherapyType("therapyType")).willReturn(Collections.singletonList(response));
        this.mockMvc.perform(get(API_URL.concat("/employees-by-therapy"))
                        .param("therapyType", "therapyType")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    private UserCreateRequest buildUserCreateRequest() {
        return UserCreateRequest.builder()
                .id(1L)
                .dni("dni")
                .name("name")
                .surname("surname")
                .phone("phone")
                .address("address")
                .city("city")
                .province("province")
                .postalCode("postalCode")
                .birthdate(LocalDate.now())
                .userType("userType")
                .therapyType("therapyType")
                .reason("reason")
                .patientRelationship("patientRelationship")
                .active(Boolean.TRUE)
                .client(UserCreateRequest.builder().id(2L).build())
                .employeeId(3L)
                .build();
    }

    private SearchRequest buildSearchRequest() {
        return SearchRequest.builder()
                .dni("dni")
                .name("name")
                .surname("surname")
                .therapyType("therapyType")
                .userType("userType")
                .build();
    }

    private SearchResponse buildSearchResponse() {
        return SearchResponse.builder()
                .id(1L)
                .dni("dni")
                .name("name")
                .surname("surname")
                .userType("userType")
                .clientFullName("name surname")
                .therapyType("therapyType")
                .clientFullName("clientFullName")
                .employeeFullName("employeeFullName")
                .build();
    }

    private UserDetailResponse buildUserDetailResponse() {
        return UserDetailResponse.builder()
                .id(1L)
                .dni("dni")
                .name("name")
                .surname("surname")
                .phone("phone")
                .address("address")
                .city("city")
                .province("province")
                .postalCode("postalCode")
                .birthdate(LocalDate.now())
                .userType("userType")
                .therapyType("therapyType")
                .reason("reason")
                .client(UserDetailResponse.builder().id(2L).build())
                .patientRelationship("patientRelationship")
                .employeeUsername("employeeUsername")
                .employeeId(3L)
                .clinicalHistoryResponse(ClinicalHistoryRR.builder().build())
                .clinicalSessionResponseList(Collections.singletonList(ClinicalSessionRR.builder().build()))
                .build();
    }

    private EmployeeResponse buildEmployeeResponse() {
        return new EmployeeResponse(1L, "employeeFullName");
    }
}
