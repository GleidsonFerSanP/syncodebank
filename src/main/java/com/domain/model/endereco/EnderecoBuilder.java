package com.domain.model.endereco;

public class EnderecoBuilder {
	
	private Endereco instance;

	public EnderecoBuilder() {
		this.instance = new Endereco();
	}
	
	public EnderecoBuilder logradouro(String logradouro) {
		this.instance.setLogradouro(logradouro);
		return this;
	}

	public EnderecoBuilder numero(String numero) {
		this.instance.setNumero(numero);
		return this;
	}

	public EnderecoBuilder complemento(String complemento) {
		this.instance.setComplemento(complemento);
		return this;
	}

	public EnderecoBuilder bairro(String bairro) {
		this.instance.setBairro(bairro);
		return this;
	}
	
	public EnderecoBuilder cidade(String cidade) {
		this.instance.setCidade(cidade);
		return this;
	}

	public EnderecoBuilder estado(Estado estado) {
		this.instance.setEstado(estado);
		return this;
	}
	
	public Endereco build() {
		return this.instance;
	}

}
