package com.domain.model.cliente;

import java.util.Date;

import com.domain.model.endereco.Endereco;

public class ClienteBuilder {
	
	private Cliente instance;

	public ClienteBuilder() {
		
		this.instance = new Cliente();
	}
	
	public ClienteBuilder nome(String nome){
		this.instance.setNome(nome);
		return this;
	}

	public ClienteBuilder cpf(String cpf){
		this.instance.setCpf(cpf);
		return this;
	}

	public ClienteBuilder email(String email){
		this.instance.setEmail(email);
		return this;
	}

	public ClienteBuilder telefone(String telefone){
		this.instance.setTelefone(telefone);
		return this;
	}

	public ClienteBuilder endereco(Endereco endereco){
		this.instance.setEndereco(endereco);
		return this;
	}

	public ClienteBuilder dataDeNascimento(Date dataDeNascimento){
		this.instance.setDataDeNascimento(dataDeNascimento);
		return this;
	}
	
	public Cliente build(){
		return this.instance;
	}

}
