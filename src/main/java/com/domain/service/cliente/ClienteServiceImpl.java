package com.domain.service.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.model.cliente.Cliente;
import com.domain.model.conta.Conta;
import com.domain.repository.cliente.ClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public Cliente consultar(Conta conta) {
		return repository.consultarPelaConta(conta);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

}
