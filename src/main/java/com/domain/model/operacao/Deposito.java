package com.domain.model.operacao;

import java.math.BigDecimal;

import com.domain.model.conta.Conta;
import com.domain.model.transacao.Transacao;
import com.domain.model.transacao.TransacaoBuilder;
import com.domain.model.transacao.TransacaoTipo;

public class Deposito extends Operacao {

	public Deposito(Conta conta, BigDecimal valor) {
		super(conta, valor);
	}

	@Override
	protected void atualizarSaldo() {
		conta.setSaldo(conta.getSaldo().add(this.valor));
	}

	@Override
	protected Transacao getTrasacao() {
		return new TransacaoBuilder()
				.contaOrigem(conta)
				.valor(valor)
				.tipo(TransacaoTipo.DEPOSITO)
				.descricao(TransacaoTipo.DEPOSITO.getDescricao())
				.build();
	}

}
