package com.extra.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.domain.model.conta.Conta;
import com.domain.model.transacao.Transacao;
import com.domain.model.transacao.TransacaoTipo;
import com.domain.repository.conta.ContaRepository;
import com.domain.repository.transacao.TransacaoRepository;
import com.extra.exceptions.FieldNullOrEmptyException;
import com.extra.exceptions.InvalidOldPasswordException;
import com.extra.exceptions.ObjectNotFoundException;
import com.extra.exceptions.PreconditionFailedException;
import com.extra.properties.MSGProperties;

@Component("transacaoValidator")
@EnableConfigurationProperties({MSGProperties.class})
public class TransacaoValidator implements IValidator{

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private TransacaoRepository transacaoRepository;

	@Override
	public void validate(Object obj) throws FieldNullOrEmptyException, ObjectNotFoundException, InvalidOldPasswordException, PreconditionFailedException {

		Transacao transacao = (Transacao) obj;

		if(transacao.getTipo().equals(TransacaoTipo.DEPOSITO)){
			if(transacao.getValor() == null)
				throw new FieldNullOrEmptyException(MSGProperties.valorVazio);
			return;
		}

		if(transacao.getTipo().equals(TransacaoTipo.SAQUE))
			if(transacao.getValor() == null)
				throw new FieldNullOrEmptyException(MSGProperties.valorVazio);

		Conta conta = contaRepository.findOne(transacao.getContaOrigem().getId());

		if(transacao.getTipo().equals(TransacaoTipo.TRANSFERENCIA)){
			if(transacao.getValor() == null)
				throw new FieldNullOrEmptyException(MSGProperties.valorVazio);

			Conta contaDestino = contaRepository.findByNumero(transacao.getContaDestino().getNumero());

			if(contaDestino == null)
				throw new ObjectNotFoundException(MSGProperties.contaNaoExiste);

		}

		if(ehTransacaoMaiorQueOSaldoEmConta(conta, transacao))
			throw new FieldNullOrEmptyException(MSGProperties.valorDaTransacaoMaiorQueOSaldo);

	}

	private boolean ehTransacaoMaiorQueOSaldoEmConta(Conta conta, Transacao transacao) {

		double somaDeSaldos = conta.getSaldo().doubleValue() + Transacao.limite.doubleValue();
		double somaDaTransacao = transacao.getValor().doubleValue() + getTarifa(conta);

		if(somaDeSaldos	< somaDaTransacao)
			return true;
		return false;
	}

	private double getTarifa(Conta conta) {
		Integer qtdSaquesNoMes = transacaoRepository.consultarQuantidadeDeSaquesDoMes(conta).intValue();

		if(qtdSaquesNoMes > 4)
			return TransacaoTipo.SAQUE.getTarifa().doubleValue();

		return 0;
	}

}
