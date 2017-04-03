package com.domain.model.transacao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.domain.model.conta.Conta;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public static BigDecimal limite = new BigDecimal("200.0");

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="transacao_seq")
	@SequenceGenerator(name="transacao_seq",sequenceName="transacao_sequence",allocationSize=1)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TransacaoTipo tipo;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Date data = new Date();
	
	@ManyToOne
	private Conta contaOrigem;

	@ManyToOne
	private Conta contaDestino;

	public Transacao() {
	}

	public Transacao(TransacaoTipo tipo) {
		this.tipo = tipo;
	}

	public Transacao(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TransacaoTipo getTipo() {
		return tipo;
	}

	public void setTipo(TransacaoTipo tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
