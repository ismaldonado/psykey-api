package com.psykey.psykeyapirest.model.security;

import lombok.Value;

import java.io.Serializable;

@Value
public class PermissionResponse implements Serializable {
    private static final long serialVersionUID = -4230243167828436714L;
    String name;
    String sectionName;
}
