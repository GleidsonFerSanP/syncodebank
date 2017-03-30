package com.application.security.custom.provider;

import com.application.security.custom.model.ICredential;

public interface ICustomAuthenticatorProvider {
	
	String authenticate(ICredential credential);
	
	Boolean checkIfAuthenticate(String token);

}
