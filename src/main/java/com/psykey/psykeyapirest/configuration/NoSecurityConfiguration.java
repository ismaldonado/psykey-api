package com.psykey.psykeyapirest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class NoSecurityConfiguration extends WebSecurityConfigurerAdapter {

    public NoSecurityConfiguration() {
    }

    @Override
    public void configure(final WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers(new String[]{"/**"});
    }
}
