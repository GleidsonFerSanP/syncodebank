package com.extra.exceptions;

public final class ObjectNotFoundException  extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String field;
	
    public ObjectNotFoundException(final String message) {
        super(message);
    }

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
