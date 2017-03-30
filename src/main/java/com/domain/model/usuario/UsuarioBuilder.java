package com.domain.model.usuario;

public class UsuarioBuilder {
	
	private Usuario instance;

	public UsuarioBuilder() {
		this.instance = new Usuario();
	}
	
	public UsuarioBuilder nome(String nome) {
		this.instance.setNome(nome);
		return this;
	}

	public UsuarioBuilder login(String login) {
		this.instance.setLogin(login);
		return this;
	}

	public UsuarioBuilder senha(String senha) {
		this.instance.setSenha(senha);
		return this;
	}
	
	public Usuario build() {
		return this.instance;
	}

}
