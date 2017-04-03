package com.extra.validators;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.domain.model.cliente.Cliente;
import com.extra.exceptions.FieldNullOrEmptyException;
import com.extra.exceptions.InvalidOldPasswordException;
import com.extra.exceptions.ObjectNotFoundException;
import com.extra.exceptions.PreconditionFailedException;
import com.extra.properties.MSGProperties;
import com.extra.util.StringUteis;

@Component("clienteValidator")
@EnableConfigurationProperties({MSGProperties.class})
public class ClienteValidator implements IValidator{
	
	@Override
	public void validate(Object obj) throws FieldNullOrEmptyException, ObjectNotFoundException, InvalidOldPasswordException, PreconditionFailedException {
		
		Cliente cliente = (Cliente) obj;
		
		validarDadosPessoais(cliente);

		validarEndereco(cliente);
	}

	private void validarDadosPessoais(Cliente cliente) throws FieldNullOrEmptyException, PreconditionFailedException {
		if(StringUteis.isNullOrEmpty(cliente.getNome()))
			throw new FieldNullOrEmptyException(MSGProperties.nomeVazio);

		if(StringUteis.isNullOrEmpty(cliente.getCpf()))
			throw new FieldNullOrEmptyException(MSGProperties.cpfVazio);
		
		if(!CpfValidator.ehCpfValido(cliente.getCpf()))
			throw new PreconditionFailedException(MSGProperties.cpfInvalido);
		
		if(StringUteis.isNullOrEmpty(cliente.getEmail()))
			throw new FieldNullOrEmptyException(MSGProperties.emailVazio);

		if(StringUteis.isNullOrEmpty(cliente.getTelefone()))
			throw new FieldNullOrEmptyException(MSGProperties.emailInvalido);
		
		if(cliente.getEndereco() == null)
			throw new FieldNullOrEmptyException(MSGProperties.enderecoVazio);
	}

	private void validarEndereco(Cliente cliente) throws FieldNullOrEmptyException {
		if(StringUteis.isNullOrEmpty(cliente.getEndereco().getLogradouro()))
			throw new FieldNullOrEmptyException(MSGProperties.enderecoLogradouroVazio);

		if(StringUteis.isNullOrEmpty(cliente.getEndereco().getNumero()))
			throw new FieldNullOrEmptyException(MSGProperties.enderecoNumeroVazio);
		
		if(StringUteis.isNullOrEmpty(cliente.getEndereco().getComplemento()))
			throw new FieldNullOrEmptyException(MSGProperties.enderecoComplementoVazio);
		
		if(StringUteis.isNullOrEmpty(cliente.getEndereco().getBairro()))
			throw new FieldNullOrEmptyException(MSGProperties.enderecoBairroVazio);

		if(StringUteis.isNullOrEmpty(cliente.getEndereco().getCidade()))
			throw new FieldNullOrEmptyException(MSGProperties.enderecoCidadeVazio);

		if(cliente.getEndereco().getEstado() == null)
			throw new FieldNullOrEmptyException(MSGProperties.enderecoEstadoVazio);
	}
 
}
