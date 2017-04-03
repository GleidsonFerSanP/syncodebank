package com.domain.model.operacao;

import java.math.BigDecimal;

import com.domain.model.conta.Conta;
import com.domain.model.transacao.Transacao;
import com.domain.model.transacao.TransacaoBuilder;
import com.domain.model.transacao.TransacaoTipo;

public class Tarifacao extends Operacao {
	
	private String descricao;

	public Tarifacao(Conta conta,String descricao, BigDecimal valor) {
		super(conta, valor);
		this.descricao = descricao;
	}

	@Override
	protected void atualizarSaldo() {
		conta.setSaldo(conta.getSaldo().subtract(this.valor));
	}

	@Override
	protected Transacao getTrasacao() {
		return new TransacaoBuilder()
				.contaOrigem(conta)
				.valor(valor)
				.tipo(TransacaoTipo.TARIFACAO)
				.descricao(descricao)
				.build();
	}

}
