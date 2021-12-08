package com.psykey.psykeyapirest.service.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.psykey.psykeyapirest.exception.JwtException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private static final String BEARER = "Bearer";
    private static final String USER = "user";
    private static final String ISSUER = "psykey";
    private static final int EXPIRED_IN_MILLISECONDS = 36000000;
	private final String secret;
	
	JwtService(@Value("${jwt.secret}") final String secret) {
		this.secret = secret;
	}

    public String createToken(final String user) {
        return JWT.create()
                .withIssuer(ISSUER)
                .withIssuedAt(new Date())
                .withNotBefore(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRED_IN_MILLISECONDS))
                .withClaim(USER, user)
                .sign(Algorithm.HMAC256(this.secret));
    }

    public boolean isBearer(final String auth) {
        return auth != null && auth.startsWith(BEARER) && auth.split("\\.").length == 3;
    }

    public String user(final String auth) throws JwtException {
        return this.verify(auth).getClaim(USER).asString();
    }

    private DecodedJWT verify(final String auth) throws JwtException {
        if (!this.isBearer(auth)) {
            throw new JwtException("No es Bearer");
        }
        try {
            return JWT.require(Algorithm.HMAC256(this.secret))
                    .withIssuer(ISSUER).build()
                    .verify(auth.substring(BEARER.length() + 1));
        } catch (final Exception exception) {
            throw new JwtException("JWT erroneo. " + exception.getMessage());
        }
    }
}
