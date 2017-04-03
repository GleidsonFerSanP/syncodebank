package com.domain.repository.transacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.model.conta.Conta;
import com.domain.model.transacao.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>, TransacaoRepositoryCustom{

	
}
