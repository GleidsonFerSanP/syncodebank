package com.domain.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.model.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
