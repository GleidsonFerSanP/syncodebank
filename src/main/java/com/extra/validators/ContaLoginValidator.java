package com.extra.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.domain.model.conta.Agencia;
import com.domain.model.conta.Conta;
import com.domain.repository.agencia.AgenciaRepository;
import com.domain.repository.conta.ContaRepository;
import com.extra.exceptions.FieldNullOrEmptyException;
import com.extra.exceptions.InvalidOldPasswordException;
import com.extra.exceptions.ObjectNotFoundException;
import com.extra.properties.MSGProperties;

@Component("contaLoginValidator")
public class ContaLoginValidator implements IValidator{
	
	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private AgenciaRepository agenciaRepository;

	@Override
	public void validate(Object obj) throws FieldNullOrEmptyException, ObjectNotFoundException, InvalidOldPasswordException {
		
		Conta conta = (Conta) obj;
		
		if(conta.getAgencia() == null)
			throw new FieldNullOrEmptyException(MSGProperties.agenciaVazia);

		if(conta.getAgencia().getNumero() == null)
			throw new FieldNullOrEmptyException(MSGProperties.agenciaNumeroVazio);

		Agencia agencia = agenciaRepository.findByNumero(conta.getAgencia().getNumero());
		
		if(agencia == null)
			throw new ObjectNotFoundException(MSGProperties.agenciaNaoExiste);
		
		if(conta.getNumero() == null)
			throw new FieldNullOrEmptyException(MSGProperties.contaNumeroVazio);
		
		Conta contaAux = contaRepository.findByNumero(conta.getNumero());
		
		if(contaAux == null)
			throw new ObjectNotFoundException(MSGProperties.contaNaoExiste);
		
		if(conta.getSenha() == null)
			throw new FieldNullOrEmptyException(MSGProperties.contaSenhaVazio);
		
		if(!conta.getPassword().equals(contaAux.getPassword()))
			throw new InvalidOldPasswordException(MSGProperties.contaSenhaNaoConfere);
		
		
	}

 
}
