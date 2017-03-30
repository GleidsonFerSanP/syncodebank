package com.application.security.custom.provider;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.security.custom.model.ICredential;
import com.application.security.custom.util.TokenService;
import com.domain.model.conta.Conta;
import com.domain.repository.conta.ContaRepository;
import com.extra.util.StringUteis;

@Component("contaAuthenticatorProvider")
public class ContaAuthenticatorProviderImpl implements ICustomAuthenticatorProvider{
	
	static Logger logger = Logger.getLogger(ContaAuthenticatorProviderImpl.class);

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@Override
	public String authenticate(ICredential credential){

		Conta conta = (Conta) credential;
		
		conta = contaRepository.findByNumero(conta.getNumero());
		
		logger.info("CLIENTE LOGOU CONTA:"+conta.getNumero());
		
		String token = generateToken(conta);
		
		return token;
	}

	private String generateToken(Conta conta) {
		
		String token = tokenService.generateToken(conta.getClass().getSimpleName(), conta.getId().toString());
		
		conta.setToken(token);
		
		contaRepository.save(conta);
		
		return token;
	}

	@Override
	public Boolean checkIfAuthenticate(String token) {
		
		if(StringUteis.isNullOrEmpty(token)){
			return false;
		}
		
		Conta conta = contaRepository.findByToken(token);
		
		if(conta == null){
			return false;
		}
		
		return true;
	}

}
