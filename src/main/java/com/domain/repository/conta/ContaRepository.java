package com.domain.repository.conta;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.model.conta.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

	Conta findByNumero(Integer login);

	Conta findByToken(String token);

}
