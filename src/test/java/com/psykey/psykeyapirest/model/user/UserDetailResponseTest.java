package com.psykey.psykeyapirest.model.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.psykey.psykeyapirest.model.user.clinicalhistory.ClinicalHistoryRR;
import com.psykey.psykeyapirest.model.user.clinicalsession.ClinicalSessionRR;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.util.Collections;


@JsonTest
@ContextConfiguration(classes = UserDetailResponseTest.class)
class UserDetailResponseTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JacksonTester<UserDetailResponse> json;

    @Test
    @SneakyThrows
    void userDetailResponse_serializationAndDeserializationTest() {
        JacksonTester.initFields(this, this.objectMapper);
        final String original = this.json.write(this.buildUserDetailResponse()).getJson();
        final UserDetailResponse userDetailResponse = this.objectMapper.readValue(original, UserDetailResponse.class);
        Assertions.assertEquals(this.json.write(userDetailResponse).getJson(), original);
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
}
