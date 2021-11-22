package com.psykey.psykeyapirest.exception;

public class JwtException extends RuntimeException {
    private final String message;

    public JwtException(final String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
