package com.domain.model.cliente;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

import com.domain.model.endereco.Endereco;
import com.extra.annotations.ValidCpf;
import com.extra.annotations.ValidEmail;

@Entity
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="cliente_seq")
	@SequenceGenerator(name="cliente_seq",sequenceName="cliente_sequence",allocationSize=1)
	private Long id;

	@NotEmpty(message = "O nome não pode ser vazio")
	@Column(length = 150, nullable = false)
	private String nome;
	
	@Column(length = 100, unique = true, nullable = false)
	@NotEmpty(message = "O cpf não pode ser vazio")
	@ValidCpf(message = "O cpf inserido é inválido")
	private String cpf;
	
	@Column(length = 100, unique = true, nullable = false)
	@NotEmpty(message = "O email não pode ser vazio")
	@ValidEmail(message = "O email inserido é inválido")
	private String email;

	@Column(length = 20)
	private String telefone;
	
	@Embedded
	private Endereco endereco;
	
	private Date dataDeCadastro = new Date();
	
	private Date dataDeNascimento;

	@Column(nullable = false)
	private String senha;

	public Cliente(Long id) {
		this.id = id;
	}

	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
