package com.domain.model.operacao;

import java.math.BigDecimal;

import com.domain.model.conta.Conta;
import com.domain.model.transacao.Transacao;
import com.domain.model.transacao.TransacaoBuilder;
import com.domain.model.transacao.TransacaoTipo;

public class Saque extends Operacao {

	public Saque(Conta conta, BigDecimal valor) {
		super(conta, valor);
	}

	@Override
	protected void atualizarSaldo() {
		conta.setSaldo(conta.getSaldo().subtract(this.valor));
	}

	@Override
	protected Transacao getTrasacao() {
		return new TransacaoBuilder()
				.contaOrigem(conta)
				.tipo(TransacaoTipo.SAQUE)
				.valor(valor)
				.descricao(TransacaoTipo.SAQUE.getDescricao())
				.build();
	}

}
