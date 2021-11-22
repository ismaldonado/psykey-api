package com.psykey.psykeyapirest.model.converter.user;

import com.psykey.psykeyapirest.model.user.UserDetailResponse;
import com.psykey.psykeyapirest.model.user.clinicalhistory.ClinicalHistoryRR;
import com.psykey.psykeyapirest.model.user.clinicalsession.ClinicalSessionRR;
import com.psykey.psykeyapirest.repository.model.user.User;
import com.psykey.psykeyapirest.service.clinicalhistory.ClinicalHistoryService;
import com.psykey.psykeyapirest.service.user.ClinicalSessionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class UserToUserDetailResponseConverter {
    private final ClinicalHistoryService clinicalHistoryService;
    private final ClinicalSessionService clinicalSessionService;

    @Autowired
    UserToUserDetailResponseConverter(final ClinicalHistoryService clinicalHistoryService,
                                      final ClinicalSessionService clinicalSessionService) {
        this.clinicalHistoryService = clinicalHistoryService;
        this.clinicalSessionService = clinicalSessionService;
    }

    public UserDetailResponse convert(final User user, final String userLogged) {
        return UserDetailResponse.builder()
                .id(user.getId())
                .dni(user.getDni())
                .name(user.getName())
                .surname(user.getSurname())
                .phone(user.getPhone())
                .address(user.getAddress())
                .city(user.getCity())
                .province(user.getProvince())
                .postalCode(user.getPostalCode())
                .birthdate(user.getBirthdate())
                .userType(user.getUserType())
                .therapyType(user.getTherapyType())
                .reason(user.getReason())
                .client(this.getClientDetail(user.getClient()))
                .patientRelationship(user.getPatientRelationship())
                .employeeUsername(this.getEmployeeUsername(user.getEmployee()))
                .employeeId(this.getEmployeeId(user.getEmployee()))
                .clinicalHistoryResponse(this.getClinicalHistoryResponse(user.getEmployee(), userLogged, user.getId()))
                .clinicalSessionResponseList(this.getClinicalSessionResponseList(user.getEmployee(), userLogged, user.getId()))
                .build();
    }

    private UserDetailResponse getClientDetail(final User client) {
        return Objects.nonNull(client) ? this.convert(client, null) : null;
    }

    private String getEmployeeUsername(final User employee) {
        return Objects.nonNull(employee)
                ? employee.getUsername()
                : null;
    }

    private Long getEmployeeId(final User employee) {
        return Objects.nonNull(employee)
                ? employee.getId()
                : null;
    }

    private ClinicalHistoryRR getClinicalHistoryResponse(final User employee,
                                                         final String userLogged,
                                                         final Long patientId) {
        final String employeeUserName = Objects.nonNull(employee) ? employee.getUsername() : null;
        return StringUtils.isNoneBlank(employeeUserName, userLogged) && employeeUserName.equals(userLogged)
                ? this.clinicalHistoryService.getClinicalHistoryResponse(patientId)
                : null;
    }

    private List<ClinicalSessionRR> getClinicalSessionResponseList(final User employee,
                                                                   final String userLogged,
                                                                   final Long patientId) {
        final String employeeUserName = Objects.nonNull(employee) ? employee.getUsername() : null;
        return StringUtils.isNoneBlank(employeeUserName, userLogged) && employeeUserName.equals(userLogged)
                ? this.clinicalSessionService.getClinicalSessionResponse(patientId)
                : null;
    }
}
