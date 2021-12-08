package com.psykey.psykeyapirest.exception;

public class JwtException extends RuntimeException {
	private static final long serialVersionUID = 8989267611599905386L;
	private final String message;

    public JwtException(final String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
