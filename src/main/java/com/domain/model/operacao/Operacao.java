package com.domain.model.operacao;

import java.math.BigDecimal;

import com.domain.model.conta.Conta;
import com.domain.model.transacao.Transacao;

public abstract class Operacao {

	protected Conta conta;
	protected BigDecimal valor;
	protected BigDecimal saldoAtualizado;
	
	public Operacao(Conta conta, BigDecimal valor) {
		this.conta = conta;
		this.valor = valor;
	}
	
	public Transacao execute(){
		atualizarSaldo();
		return getTrasacao();
	}

	protected abstract void atualizarSaldo();
	
	protected abstract Transacao getTrasacao();
	
	protected BigDecimal getSaldoAtualizado() {
		return this.saldoAtualizado;
	}
	
}
