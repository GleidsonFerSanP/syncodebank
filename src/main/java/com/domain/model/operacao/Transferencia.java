package com.domain.model.operacao;

import java.math.BigDecimal;

import com.domain.model.conta.Conta;
import com.domain.model.transacao.Transacao;
import com.domain.model.transacao.TransacaoBuilder;
import com.domain.model.transacao.TransacaoTipo;
import com.extra.exceptions.FieldNullOrEmptyException;

public class Transferencia extends Operacao {
	
	private Conta contaDestino;

	public Transferencia(Conta conta,Conta contaDestino, BigDecimal valor) throws FieldNullOrEmptyException {
		super(conta, valor);
		if(contaDestino == null)
			throw new FieldNullOrEmptyException("Conta de destino obrigatória");
		this.contaDestino = contaDestino;
	}

	@Override
	protected void atualizarSaldo() {
		conta.setSaldo(conta.getSaldo().subtract(this.valor));
		contaDestino.setSaldo(contaDestino.getSaldo().add(this.valor));
	}

	@Override
	protected Transacao getTrasacao() {
		return new TransacaoBuilder()
				.contaOrigem(conta)
				.contaDestino(this.contaDestino)
				.tipo(TransacaoTipo.TRANSFERENCIA)
				.valor(valor)
				.descricao(TransacaoTipo.TRANSFERENCIA.getDescricao())
				.build();
	}

}
