package com.extra.exceptions;

public class FieldNullOrEmptyException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String field;
	
    public FieldNullOrEmptyException(final String message) {
        super(message);
    }

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
