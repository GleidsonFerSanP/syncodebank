package com.application.security.custom.model;

public class Token {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Token(String value) {
		super();
		this.value = value;
	}
}
