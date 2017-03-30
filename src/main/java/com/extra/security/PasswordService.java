package com.extra.security;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

	@Autowired
	private Random random;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String novaSenha(String prefixo) {
		
		for (int i = 0; i < 4; i++) {
			prefixo += random.nextInt(10);
		}

		return prefixo;
	}
	
	public String encode(String senha){
		return passwordEncoder.encode(senha);
	}

	public String encodeBase64(String senha){
		return PasswordBase64.encode(senha);
	}
	
	public String decodeBase64(String senha){
		return PasswordBase64.decode(senha);
	}
	
}
