package com.domain.resources.conta;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.model.conta.Conta;
import com.domain.service.conta.IContaService;

@RestController
@RequestMapping("/api/v1/contas")
public class ContaResource {
	
	@Autowired
	private IContaService contaService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> conta(HttpServletRequest request){
		
		Long idConta = (Long) request.getAttribute("idConta");
		
		return ResponseEntity.ok(contaService.consultar(new Conta(idConta)));
	}

}
