package com.domain.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.model.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByToken(String token);

	Usuario findByLogin(String login);

}
