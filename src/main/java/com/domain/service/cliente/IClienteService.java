package com.domain.service.cliente;

import com.domain.model.cliente.Cliente;
import com.domain.model.conta.Conta;

public interface IClienteService {

	Cliente consultar(Conta conta);

	Cliente save(Cliente cliente);

}
