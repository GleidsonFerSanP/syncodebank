package com.domain.repository.transacao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.domain.model.conta.Conta;
import com.domain.model.transacao.Transacao;
import com.domain.model.transacao.TransacaoTipo;
import com.extra.util.DateUtils;

@Repository
public class TransacaoRepositoryCustomImpl implements TransacaoRepositoryCustom {

	@Autowired
	private EntityManager em;

	@Override
	public Long consultarQuantidadeDeSaquesDoMes(Conta contaOrigem) {

		DetachedCriteria dc = DetachedCriteria.forClass(Transacao.class);

		DateTime inicio = new DateTime().dayOfMonth().withMinimumValue();

		dc.add(Restrictions.between("data", DateUtils.inicioDia(inicio.toDate()), new Date()));
		dc.createAlias("contaOrigem", "c");
		dc.add(Restrictions.eq("c.id", contaOrigem.getId()));
		dc.add(Restrictions.eq("tipo", TransacaoTipo.SAQUE));
		dc.setProjection(Projections.rowCount());

		Criteria criteria = dc.getExecutableCriteria(em.unwrap(Session.class));

		return (Long) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transacao> listarTransacoesDaConta(Conta conta) {
		DetachedCriteria dc = DetachedCriteria.forClass(Transacao.class);

		DateTime inicio = new DateTime().dayOfMonth().withMinimumValue();

		dc.add(Restrictions.between("data", DateUtils.inicioDia(inicio.toDate()), new Date()));
		
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.eq("contaOrigem.id", conta.getId()));
		disjunction.add(Restrictions.eq("contaDestino.id", conta.getId()));
		
		dc.add(disjunction);

		Criteria criteria = dc.getExecutableCriteria(em.unwrap(Session.class));

		return criteria.list();
	}

}
