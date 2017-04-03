package com.domain.resources.cliente;

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

import com.domain.model.cliente.Cliente;
import com.domain.model.conta.Conta;
import com.domain.service.cliente.IClienteService;
import com.extra.exceptions.FieldNullOrEmptyException;
import com.extra.exceptions.InvalidOldPasswordException;
import com.extra.exceptions.ObjectNotFoundException;
import com.extra.exceptions.PreconditionFailedException;
import com.extra.validators.ClienteValidator;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteResource {
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("clienteValidator")
	private ClienteValidator validator;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> conta(HttpServletRequest request){
		
		Long idConta = (Long) request.getAttribute("idConta");
		
		return ResponseEntity.ok(clienteService.consultar(new Conta(idConta)));
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody Cliente cliente, HttpServletRequest request){
		
		try {
			validator.validate(cliente);
			return ResponseEntity.ok(clienteService.save(cliente));
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
