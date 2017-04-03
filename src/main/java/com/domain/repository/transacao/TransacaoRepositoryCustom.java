package com.domain.repository.transacao;

import java.util.List;

import com.domain.model.conta.Conta;
import com.domain.model.transacao.Transacao;

public interface TransacaoRepositoryCustom {
	
	List<Transacao> listarTransacoesDaConta(Conta conta);
	
	Long consultarQuantidadeDeSaquesDoMes(Conta contaOrigem);

}
