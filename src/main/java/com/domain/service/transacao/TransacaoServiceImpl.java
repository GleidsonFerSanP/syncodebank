package com.domain.service.transacao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.model.conta.Conta;
import com.domain.model.operacao.Deposito;
import com.domain.model.operacao.Operacao;
import com.domain.model.operacao.Saque;
import com.domain.model.operacao.Tarifacao;
import com.domain.model.operacao.Transferencia;
import com.domain.model.transacao.Transacao;
import com.domain.model.transacao.TransacaoTipo;
import com.domain.repository.conta.ContaRepository;
import com.domain.repository.transacao.TransacaoRepository;
import com.extra.exceptions.FieldNullOrEmptyException;
import com.extra.exceptions.ObjectNotFoundException;
import com.extra.properties.MSGProperties;

@Service
public class TransacaoServiceImpl implements ITransacaoService{

	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private ContaRepository contaRepository;

	@Override
	public Transacao deposito(Conta conta, Transacao transacao) throws ObjectNotFoundException {
		conta = contaRepository.findOne(conta.getId());
		
		if(conta == null)
			throw new ObjectNotFoundException(MSGProperties.contaNaoExiste);
		
		BigDecimal valor = transacao.getValor();
		
		Operacao deposito = new Deposito(conta, valor);
		
		transacao = deposito.execute();
		
		salvarContaETransacao(conta, transacao);
		
		return transacao;
	}

	@Override
	public List<Transacao> listar(Conta conta) {
		return transacaoRepository.listarTransacoesDaConta(conta);
	}

	@Override
	public Transacao saque(Conta conta, Transacao transacao) throws ObjectNotFoundException {
		conta = contaRepository.findOne(conta.getId());
		
		if(conta == null)
			throw new ObjectNotFoundException(MSGProperties.contaNaoExiste);
		
		BigDecimal valor = transacao.getValor();
		Operacao saque = new Saque(conta, valor);
		
		transacao = saque.execute();
		
		tarifarSaque(conta);
		
		salvarContaETransacao(conta, transacao);
		
		return transacao;
	}

	private void salvarContaETransacao(Conta conta, Transacao transacao) {
		transacaoRepository.save(transacao);
		
		contaRepository.save(conta);
	}

	private void tarifarSaque(Conta conta) {
		Long qtdSaquesNoMes = transacaoRepository.consultarQuantidadeDeSaquesDoMes(conta);
		
		if(qtdSaquesNoMes < 4)
			return;
		
		BigDecimal valor = TransacaoTipo.SAQUE.getTarifa();
		Operacao saque = new Tarifacao(conta, "Tarifa por quantidade de saque mensais excedidos", valor);
		Transacao transacao = saque.execute();
		
		salvarContaETransacao(conta, transacao);
		
	}

	@Override
	public Transacao transferencia(Conta conta, Transacao transacao) throws ObjectNotFoundException, FieldNullOrEmptyException {
		conta = contaRepository.findOne(conta.getId());

		Conta contaDestino = contaRepository.findByNumero(transacao.getContaDestino().getNumero());
		
		if(conta == null)
			throw new ObjectNotFoundException(MSGProperties.contaNaoExiste);
		
		BigDecimal valor = transacao.getValor();
		
		Operacao transferencia = new Transferencia(conta, contaDestino , valor);
		
		transacao = transferencia.execute();
		
		tarifarTransferencia(conta);
		
		salvarContaETransacao(conta, transacao);
		salvarContaETransacao(contaDestino, transacao);
		
		return transacao;
	}

	private void tarifarTransferencia(Conta conta) {
		
		BigDecimal valor = TransacaoTipo.TRANSFERENCIA.getTarifa();
		Operacao saque = new Tarifacao(conta, "Tarifa transferência entre contas correntes", valor);
		Transacao transacao = saque.execute();
		
		salvarContaETransacao(conta, transacao);
		
	}
	
	
	
}
