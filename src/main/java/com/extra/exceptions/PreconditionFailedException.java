package com.extra.exceptions;

public class PreconditionFailedException extends Exception {

    private static final long serialVersionUID = 5861310537366287163L;

    public PreconditionFailedException(final String message) {
        super(message);
    }


}
