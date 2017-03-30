package com.extra.exceptions;

public final class NotAuthenticateException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public NotAuthenticateException() {
        super();
    }

    public NotAuthenticateException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NotAuthenticateException(final String message) {
        super(message);
    }

    public NotAuthenticateException(final Throwable cause) {
        super(cause);
    }

}
