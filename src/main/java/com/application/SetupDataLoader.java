package com.application;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.domain.model.cliente.ClienteBuilder;
import com.domain.model.conta.Agencia;
import com.domain.model.conta.Conta;
import com.domain.model.conta.ContaBuilder;
import com.domain.model.endereco.EnderecoBuilder;
import com.domain.model.endereco.Estado;
import com.domain.model.transacao.TransacaoBuilder;
import com.domain.model.usuario.Usuario;
import com.domain.model.usuario.UsuarioBuilder;
import com.domain.repository.conta.ContaRepository;
import com.domain.repository.usuario.UsuarioRepository;
import com.domain.service.transacao.ITransacaoService;
import com.extra.exceptions.ObjectNotFoundException;
import com.extra.util.DateUtils;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ITransacaoService transacaoService; 
	
	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		
		Usuario usuario = new UsuarioBuilder()
				.nome("Syncode Sistemas e Tecnologia")
				.login("syncode")
				.senha("syncode")
				.build();
		
		usuarioRepository.save(usuario);
		
		gerarClientesIniciaisComContas();
		
	}

	private void gerarClientesIniciaisComContas() {
		Conta conta1 = gerarContaCliente1();
		contaRepository.save(conta1);
		
		try {
			transacaoService.deposito(conta1, new TransacaoBuilder()
					.valor(new BigDecimal("100"))
					.build());

			Conta conta2 = gerarContaCliente2(conta1.getAgencia());
			contaRepository.save(conta2);
			
			transacaoService.deposito(conta2, new TransacaoBuilder()
					.valor(new BigDecimal("200"))
					.build());
			
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Conta gerarContaCliente2(Agencia agencia) {
		return new ContaBuilder()
				.agencia(agencia)
				.numero(54321)
				.digito(6)
				.senha("123456")
				.cliente(
						new ClienteBuilder()
						.nome("Artur Antunes Coimbra")
						.dataDeNascimento(DateUtils.convertStringToDate("03/03/1953", "dd/MM/yyyy"))
						.email("zico@email.com")
						.telefone("62 3996 9600​")
						.endereco(
								new EnderecoBuilder()
								.logradouro("Av. Pasteur")
								.numero("233")
								.complemento("Salas 14 a 21, Galeria Plaza")
								.cidade("Goiânia")
								.estado(Estado.GO)
								.bairro("Parque Anhanguera")
								.build()
								)
						.cpf("829.234.554-01")
						.build())
				.build();
	}

	private Conta gerarContaCliente1() {
		return new ContaBuilder()
				.agencia(new Agencia("Agência Galeria Plaza", 1234))
				.numero(12345)
				.digito(6)
				.senha("123456")
				.cliente(
						new ClienteBuilder()
						.nome("Paulo Roberto Falcão")
						.dataDeNascimento(DateUtils.convertStringToDate("16/10/1953", "dd/MM/yyyy"))
						.email("paulo.roberto.falcao@email.com")
						.telefone("62 3996 9600​")
						.endereco(
								new EnderecoBuilder()
								.logradouro("Av. Pasteur")
								.numero("233")
								.complemento("Salas 14 a 21, Galeria Plaza")
								.cidade("Goiânia")
								.estado(Estado.GO)
								.bairro("Parque Anhanguera")
								.build()
								)
						.cpf("163.730.624-57")
						.build())
				.build();
	}
	

}