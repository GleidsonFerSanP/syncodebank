package com.application.security.custom.util;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.extra.security.PasswordService;

@Component
public class TokenService {
	
	@Autowired
	private PasswordService passwordService;

	public String generateToken(String entityName, String id){
		
		String primeiraParte = getRadomValue().toString();
		
		String segundaParte = getRadomValue().toString();
		
		StringBuilder token = new StringBuilder();
		
		token.append(passwordService.encodeBase64(primeiraParte));
		token.append(".-.");
		token.append(passwordService.encodeBase64(entityName));
		token.append("-.-");
		token.append(passwordService.encodeBase64(id));
		token.append("...");
		token.append(passwordService.encodeBase64(segundaParte));
		
		return token.toString();
	}
	
	private UUID getRadomValue(){
		return UUID.randomUUID();
	}
	
	public String getIdInToken(String token){
		
		String id = token.substring(token.indexOf("-.-")+3,token.indexOf("..."));
		
		return passwordService.decodeBase64(id);
	}
	
	public String getTokenInRequest(HttpServletRequest httpRequest) {
		Enumeration<String> headerNames = httpRequest.getHeaderNames();

		if (headerNames != null) {
			return httpRequest.getHeader("Authorization");
		}

		return null;
	}

}
