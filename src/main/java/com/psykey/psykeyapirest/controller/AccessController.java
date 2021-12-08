package com.psykey.psykeyapirest.controller;

import com.psykey.psykeyapirest.model.security.AccessRequest;
import com.psykey.psykeyapirest.model.security.AccessResponse;
import com.psykey.psykeyapirest.service.access.AccessService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/access")
public class AccessController {

    private final AccessService accessService;

    public AccessController(final AccessService accessService) {
        this.accessService = accessService;
    }

    @PostMapping(value = "/create-access", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AccessResponse createAccess(@RequestBody final AccessRequest accessRequest) {
        return this.accessService.saveUser(accessRequest, null, accessRequest.getUserFullName(), null);
    }
}
