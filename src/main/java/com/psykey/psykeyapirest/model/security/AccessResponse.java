package com.psykey.psykeyapirest.model.security;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Value
@Builder
public class AccessResponse implements Serializable {
    private static final long serialVersionUID = -3149726555016678265L;
    String username;
    String userFullName;
    String rol;
    String authToken;
    List<PermissionResponse> permissions;
}
