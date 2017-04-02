package com.domain.model.conta;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Proxy;

import com.application.security.custom.model.ICredential;
import com.domain.model.cliente.Cliente;
import com.extra.security.PasswordBase64;
import com.extra.util.StringUteis;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Proxy(lazy = false)
public class Conta implements ICredential, Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="conta_seq")
	@SequenceGenerator(name="conta_seq",sequenceName="conta_sequence",allocationSize=1)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Agencia agencia;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cliente cliente;

	@Column(nullable = false)
	private Integer numero;

	@Column(nullable = false)
	private Integer digito;
	
	private BigDecimal saldo = new BigDecimal("0.0");
	
	@JsonIgnore
	@Column(nullable = false, length = 1024)
	private String senha;
	
	@JsonIgnore
	@Column(length = 1024)
	private String token;
	
	private Date dataAbertura = new Date();
	
	public Conta() {
	}

	public Conta(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getSenha() {
		return StringUteis.isNullOrEmpty(this.senha) ? null:PasswordBase64.decode(this.senha);
	}

	public void setSenha(String senha) {
		if(StringUteis.isNullOrEmpty(senha))
			return;
		this.senha = PasswordBase64.encode(senha);;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getDigito() {
		return digito;
	}

	public void setDigito(Integer digito) {
		this.digito = digito;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	@JsonIgnore
	public String getLogin() {
		return this.agencia.getNumero()+"-"+this.numero;
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		return this.senha;
	}

}
