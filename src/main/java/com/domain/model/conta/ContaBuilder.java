package com.domain.model.conta;

import java.math.BigDecimal;

import com.domain.model.cliente.Cliente;

public class ContaBuilder {

	private Conta instance;

	public ContaBuilder() {
		this.instance = new Conta();
	}
	
	public ContaBuilder numero(Integer numero) {
		this.instance.setNumero(numero);
		return this;
	}

	public ContaBuilder digito(Integer digito) {
		this.instance.setDigito(digito);
		return this;
	}

	public ContaBuilder agencia(Agencia agencia) {
		this.instance.setAgencia(agencia);
		return this;
	}

	public ContaBuilder cliente(Cliente cliente) {
		this.instance.setCliente(cliente);
		return this;
	}

	public ContaBuilder saldo(BigDecimal saldo) {
		this.instance.setSaldo(saldo);
		return this;
	}

	public ContaBuilder senha(String senha) {
		this.instance.setSenha(senha);
		return this;
	}
	
	public Conta build() {
		return this.instance;
	}
	
}
