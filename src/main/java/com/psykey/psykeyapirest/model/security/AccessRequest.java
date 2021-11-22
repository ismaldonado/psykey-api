package com.psykey.psykeyapirest.model.security;

import lombok.Value;

import java.io.Serializable;


@Value
public class AccessRequest implements Serializable {
    private static final long serialVersionUID = -8388393758532335206L;
    String username;
    String password;
    String userFullName;
    Long rolId;
}
