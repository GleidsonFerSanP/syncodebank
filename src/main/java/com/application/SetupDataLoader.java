package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.domain.model.usuario.Usuario;
import com.domain.model.usuario.UsuarioBuilder;
import com.domain.repository.usuario.UsuarioRepository;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		
		Usuario usuario = new UsuarioBuilder()
				.nome("Syncode Sistemas e Tecnologia")
				.login("syncode")
				.senha("syncode")
				.build();
		
		repository.save(usuario);
	}
	

}