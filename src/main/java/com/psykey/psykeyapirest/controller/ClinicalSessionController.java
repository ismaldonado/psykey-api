package com.psykey.psykeyapirest.controller;

import com.psykey.psykeyapirest.model.user.clinicalsession.ClinicalSessionRR;
import com.psykey.psykeyapirest.service.user.ClinicalSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@PreAuthorize("authenticated")
@RestController
@RequestMapping("/api/clinical-session")
public class ClinicalSessionController {
    private final ClinicalSessionService clinicalSessionService;

    @Autowired
    ClinicalSessionController(final ClinicalSessionService clinicalSessionService) {
        this.clinicalSessionService = clinicalSessionService;
    }

    @PostMapping(value = "/save-session")
    public ClinicalSessionRR createSession(@RequestBody @NotNull final ClinicalSessionRR clinicalSessionRR) {
        return this.clinicalSessionService.saveSession(clinicalSessionRR);
    }
}
