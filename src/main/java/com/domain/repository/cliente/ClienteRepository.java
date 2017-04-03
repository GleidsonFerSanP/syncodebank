package com.domain.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.model.cliente.Cliente;
import com.domain.model.conta.Conta;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryCustom {

}
