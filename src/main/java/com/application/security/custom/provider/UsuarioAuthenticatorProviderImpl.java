package com.application.security.custom.provider;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.security.custom.model.ICredential;
import com.application.security.custom.util.TokenService;
import com.domain.model.usuario.Usuario;
import com.domain.repository.usuario.UsuarioRepository;
import com.extra.util.StringUteis;

@Component(value = "usuarioAuthenticatorProvider")
public class UsuarioAuthenticatorProviderImpl implements ICustomAuthenticatorProvider{
	
	static Logger logger = Logger.getLogger(UsuarioAuthenticatorProviderImpl.class);

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@Override
	public String authenticate(ICredential credential){

		Usuario usuario = (Usuario) credential;
		
		usuario = usuarioRepository.findByLogin(usuario.getLogin());
		
		logger.info("USUÁRIO LOGOU:"+usuario.getNome());
		
		String token = generateToken(usuario);
		
		return token;
	}

	private String generateToken(Usuario usuario) {
		
		String token = tokenService.generateToken(usuario.getClass().getSimpleName(), usuario.getId().toString());
		
		usuario.setToken(token);
		
		usuarioRepository.save(usuario);
		
		return token;
	}

	@Override
	public Boolean checkIfAuthenticate(String token) {
		
		if(StringUteis.isNullOrEmpty(token)){
			return false;
		}
		
		Usuario usuario = usuarioRepository.findByToken(token);
		
		if(usuario == null){
			return false;
		}
		
		return true;
	}

}
