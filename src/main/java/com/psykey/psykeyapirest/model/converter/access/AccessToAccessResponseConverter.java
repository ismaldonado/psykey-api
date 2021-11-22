package com.psykey.psykeyapirest.model.converter.access;

import com.psykey.psykeyapirest.model.security.AccessResponse;
import com.psykey.psykeyapirest.model.security.PermissionResponse;
import com.psykey.psykeyapirest.repository.model.access.Access;
import com.psykey.psykeyapirest.repository.model.security.Permission;
import com.psykey.psykeyapirest.repository.model.security.Rol;
import com.psykey.psykeyapirest.repository.model.security.RolPermission;
import com.psykey.psykeyapirest.repository.model.security.Section;
import com.psykey.psykeyapirest.service.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AccessToAccessResponseConverter implements Converter<Access, AccessResponse> {
    private final JwtService jwtService;

    @Autowired
    AccessToAccessResponseConverter(final JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public AccessResponse convert(final Access access) {
        return AccessResponse.builder()
                .username(access.getUsername())
                .userFullName(access.getFulName())
                .rol(access.getRol().getDescription())
                .authToken(this.jwtService.createToken(access.getUsername()))
                .permissions(this.getPermissions(access.getRol()))
                .build();
    }

    private List<PermissionResponse> getPermissions(final Rol rol) {
        return Objects.nonNull(rol)
                ? rol.getRolPermissions()
                .stream()
                .map(RolPermission::getPermission)
                .map(this::buildPermissionResponse)
                .collect(Collectors.toList())
                : Collections.emptyList();
    }

    private PermissionResponse buildPermissionResponse(final Permission permission) {
        return new PermissionResponse(permission.getName(), this.getSectionName(permission.getSection()));
    }

    private String getSectionName(final Section section) {
        return Objects.nonNull(section) ? section.getName() : "";
    }
}
