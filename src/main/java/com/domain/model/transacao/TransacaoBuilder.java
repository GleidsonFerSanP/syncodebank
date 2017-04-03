package com.domain.model.transacao;

import java.math.BigDecimal;

import com.domain.model.conta.Conta;

public class TransacaoBuilder {
	
	private Transacao instance;
	
	public TransacaoBuilder() {
		this.instance = new Transacao();
	}

	public TransacaoBuilder tipo(TransacaoTipo tipo){
		this.instance.setTipo(tipo);
		return this;
	}

	public TransacaoBuilder valor(BigDecimal valor){
		this.instance.setValor(valor);
		return this;
	}

	public TransacaoBuilder contaOrigem(Conta conta){
		this.instance.setContaOrigem(conta);
		return this;
	}

	public TransacaoBuilder contaDestino(Conta conta){
		this.instance.setContaDestino(conta);
		return this;
	}

	public TransacaoBuilder descricao(String descricao){
		this.instance.setDescricao(descricao);
		return this;
	}
	
	public Transacao build() {
		return this.instance;
	}


}
