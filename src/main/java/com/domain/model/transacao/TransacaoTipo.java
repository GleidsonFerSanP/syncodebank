package com.domain.model.transacao;

import java.math.BigDecimal;

public enum TransacaoTipo {
	
	SAQUE("Saque", new BigDecimal("3.90")),
	DEPOSITO("Depósito em conta corrente", new BigDecimal("0.0")),
	TRANSFERENCIA("Transferência entre contas correntes", new BigDecimal("1.75")),
	TARIFACAO("Tarifa", null);

	private String descricao;
	private BigDecimal tarifa;
	
	private TransacaoTipo(String descricao, BigDecimal tarifa) {
		this.descricao = descricao;
		this.tarifa = tarifa;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getTarifa() {
		return tarifa;
	}
}
