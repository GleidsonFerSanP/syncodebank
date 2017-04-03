package com.domain.service.transacao;

import java.util.List;

import com.domain.model.conta.Conta;
import com.domain.model.transacao.Transacao;
import com.extra.exceptions.FieldNullOrEmptyException;
import com.extra.exceptions.ObjectNotFoundException;

public interface ITransacaoService {

	Transacao deposito(Conta conta, Transacao transacao) throws ObjectNotFoundException;

	List<Transacao> listar(Conta conta);

	Transacao saque(Conta conta, Transacao transacao) throws ObjectNotFoundException;

	Transacao transferencia(Conta conta, Transacao transacao) throws ObjectNotFoundException, FieldNullOrEmptyException;

}
