package com.domain.resources.transacao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.model.conta.Conta;
import com.domain.model.transacao.Transacao;
import com.domain.model.transacao.TransacaoTipo;
import com.domain.service.transacao.ITransacaoService;
import com.extra.exceptions.FieldNullOrEmptyException;
import com.extra.exceptions.InvalidOldPasswordException;
import com.extra.exceptions.ObjectNotFoundException;
import com.extra.exceptions.PreconditionFailedException;
import com.extra.validators.TransacaoValidator;

@RestController
@RequestMapping("/api/v1/transacoes")
public class TransacaoResource {

	@Autowired
	private ITransacaoService transacaoService;

	@Autowired
	@Qualifier("transacaoValidator")
	private TransacaoValidator validator;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> conta(HttpServletRequest request){

		Long idConta = (Long) request.getAttribute("idConta");

		return ResponseEntity.ok(transacaoService.listar(new Conta(idConta)));
	}

	@RequestMapping(value="/saque",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saque(@RequestBody Transacao transacao, HttpServletRequest request){

		Long idConta = (Long) request.getAttribute("idConta");
		Conta conta = new Conta(idConta);
		transacao.setTipo(TransacaoTipo.SAQUE);
		transacao.setContaOrigem(conta);

		try {
			validator.validate(transacao);
			return ResponseEntity.ok(transacaoService.saque(new Conta(idConta), transacao));
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		} catch (FieldNullOrEmptyException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED).body(e);
		} catch (InvalidOldPasswordException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e);
		} catch (PreconditionFailedException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e);
		}
	}

	@RequestMapping(value="/deposito",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> deposito(@RequestBody Transacao transacao, HttpServletRequest request){
		
		Long idConta = (Long) request.getAttribute("idConta");
		Conta conta = new Conta(idConta);
		transacao.setTipo(TransacaoTipo.DEPOSITO);
		transacao.setContaOrigem(conta);

		try {
			validator.validate(transacao);
			return ResponseEntity.ok(transacaoService.deposito(conta, transacao));
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		} catch (FieldNullOrEmptyException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED).body(e);
		} catch (InvalidOldPasswordException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e);
		} catch (PreconditionFailedException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e);
		}

	}

	@RequestMapping(value="/transferencia",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> transferencia(@RequestBody Transacao transacao, HttpServletRequest request){
		
		Long idConta = (Long) request.getAttribute("idConta");
		Conta conta = new Conta(idConta);
		transacao.setTipo(TransacaoTipo.TRANSFERENCIA);
		transacao.setContaOrigem(conta);
		
		try {
			validator.validate(transacao);
			return ResponseEntity.ok(transacaoService.transferencia(conta, transacao));
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		} catch (FieldNullOrEmptyException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED).body(e);
		} catch (InvalidOldPasswordException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e);
		} catch (PreconditionFailedException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e);
		}
		
	}

}
