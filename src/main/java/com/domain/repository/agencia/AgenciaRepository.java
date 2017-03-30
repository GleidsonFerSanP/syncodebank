package com.domain.repository.agencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.model.conta.Agencia;

public interface AgenciaRepository extends JpaRepository<Agencia, Long>{

	Agencia findByNumero(Integer numero);

}
