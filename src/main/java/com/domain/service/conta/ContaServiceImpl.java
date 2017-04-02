package com.domain.service.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.model.conta.Conta;
import com.domain.repository.conta.ContaRepository;

@Service
public class ContaServiceImpl implements IContaService {
	
	@Autowired
	private ContaRepository repository;

	@Override
	public Conta consultar(Conta conta) {
		return repository.getOne(conta.getId());
	}

}
