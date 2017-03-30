package com.application.security.custom.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.security.custom.model.Token;
import com.application.security.custom.provider.ICustomAuthenticatorProvider;
import com.domain.model.conta.Conta;
import com.domain.model.usuario.Usuario;
import com.extra.exceptions.FieldNullOrEmptyException;
import com.extra.exceptions.InvalidOldPasswordException;
import com.extra.exceptions.ObjectNotFoundException;
import com.extra.validators.IValidator;

@RestController
@RequestMapping("/api/v1/login")
public class LoginResource {

	@Autowired
	@Qualifier(value = "contaAuthenticatorProvider")
	private ICustomAuthenticatorProvider contaAuthenticatorProvider;

	@Autowired
	@Qualifier(value = "usuarioAuthenticatorProvider")
	private ICustomAuthenticatorProvider usuarioAuthenticatorProvider;
	
	@Autowired
	@Qualifier(value = "contaLoginValidator")
	private IValidator validator;
	
	@RequestMapping(value="/conta",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> loginConta(@RequestBody Conta conta){
		
		try {
			validator.validate(conta);
			return ResponseEntity.ok(new Token(contaAuthenticatorProvider.authenticate(conta)));
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		} catch (FieldNullOrEmptyException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED).body(e);
		} catch (InvalidOldPasswordException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e);
		}
		
	}

	@RequestMapping(value="/atendimento",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> loginAtendimento(@RequestBody Usuario usuario){
		
		try {
			validator.validate(usuario);
			return ResponseEntity.ok(new Token(usuarioAuthenticatorProvider.authenticate(usuario)));
		} catch (ObjectNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
		} catch (FieldNullOrEmptyException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED).body(e);
		} catch (InvalidOldPasswordException e) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e);
		}
		
	}
	
}
