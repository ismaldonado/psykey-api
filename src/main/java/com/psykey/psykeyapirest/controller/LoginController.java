package com.psykey.psykeyapirest.controller;

import com.psykey.psykeyapirest.model.security.AccessResponse;
import com.psykey.psykeyapirest.service.access.AccessService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
public class LoginController {
    private final AccessService accessService;

    public LoginController(final AccessService accessService) {
        this.accessService = accessService;
    }

    @PreAuthorize("authenticated")
    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccessResponse login(@AuthenticationPrincipal final User activeUser) {
        return this.accessService.getAccessResponseByUsername(activeUser.getUsername());
    }
}
