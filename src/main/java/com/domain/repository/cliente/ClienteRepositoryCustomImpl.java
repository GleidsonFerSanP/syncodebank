package com.domain.repository.cliente;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.domain.model.cliente.Cliente;
import com.domain.model.conta.Conta;

@Repository
public class ClienteRepositoryCustomImpl implements ClienteRepositoryCustom{
	
	@Autowired
	private EntityManager em;

	@Override
	public Cliente consultarPelaConta(Conta conta) {
		
		DetachedCriteria dc = DetachedCriteria.forClass(Conta.class);
		dc.createAlias("cliente", "c");
		dc.add(Restrictions.eq("id", conta.getId()));
		dc.setProjection(Projections.projectionList()
				.add(Projections.property("c.id"), "id")
				.add(Projections.property("c.nome"), "nome")
				.add(Projections.property("c.cpf"), "cpf")
				.add(Projections.property("c.endereco"), "endereco")
				.add(Projections.property("c.email"), "email")
				.add(Projections.property("c.telefone"), "telefone")
				.add(Projections.property("c.dataDeNascimento"), "dataDeNascimento")
				);
		dc.setResultTransformer(new AliasToBeanResultTransformer(Cliente.class));
		
		Criteria criteria = dc.getExecutableCriteria(em.unwrap(Session.class));
		
		return (Cliente) criteria.uniqueResult();
	}

}
