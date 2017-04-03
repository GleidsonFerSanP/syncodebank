package com.domain.repository.cliente;

import com.domain.model.cliente.Cliente;
import com.domain.model.conta.Conta;

public interface ClienteRepositoryCustom {
	
	Cliente consultarPelaConta(Conta conta);

}
