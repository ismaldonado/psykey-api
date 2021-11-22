package com.psykey.psykeyapirest.configuration.filter;

import com.psykey.psykeyapirest.service.jwt.JwtService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private JwtService jwtService;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    final HttpServletResponse response,
                                    final FilterChain filterChain)
            throws IOException, ServletException {

        final String authHeader = request.getHeader(AUTHORIZATION);
        if (this.jwtService.isBearer(authHeader)) {
            LogManager.getLogger(this.getClass().getName()).debug(">>> FILTER JWT...");
            final UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(this.jwtService.user(authHeader), null, null);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}
