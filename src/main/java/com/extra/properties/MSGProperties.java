package com.extra.properties;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(locations = "classpath:mensagens.properties", ignoreUnknownFields = false, prefix = "mensagens")
public class MSGProperties {
	
	@NotBlank
	public static String tituloVazio;
	@NotBlank
	public static String nomeExiste;
	@NotBlank
	public static String salvo;
	@NotBlank
	public static String senhasDiferentes;
	@NotBlank
	public static String novaSenhaConfirmarVazio;
	@NotBlank
	public static String novaSenhaVazio;
	@NotBlank
	public static String loginNaoRealizado;
	@NotBlank
	public static String dadosVazios;
	@NotBlank
	public static String senhaInvalida;
	@NotBlank
	public static String senhaRedefinida;
	@NotBlank
	public static String confirmarSenhaErrado;
	@NotBlank
	public static String  senhaVazio;
	@NotBlank
	public static String  confirmarSenhaVazio;
	@NotBlank
	public static String  emailExiste;
	@NotBlank
	public static String  emailVazio;
	@NotBlank
	public static String  recuperarSenhaEmailNaoExiste;
	@NotBlank
	public static String  recuperarSenhaOK;
	@NotBlank
	public static String  usuarioInserido;
	@NotBlank
	public static String  usuarioAtualizado;
	@NotBlank
	public static String  usuarioExcluido;
	@NotBlank
	public static String  emailInvalido;
	@NotBlank
	public static String  nomeVazio;
	@NotBlank
	public static String  assuntoEmailRedefinicaoSenha;
	@NotBlank
	public static String excluido;
	@NotBlank
	public static String cpfVazio;
	@NotBlank
	public static String telefoneVazio;
	@NotBlank
	public static String celularVazio;
	@NotBlank
	public static String cpfJaExiste;
	@NotBlank
	public static String cpfInvalido;
	@NotBlank
	public static String agenciaVazia;
	@NotBlank
	public static String agenciaNumeroVazio;
	@NotBlank
	public static String contaNumeroVazio;
	@NotBlank
	public static String contaSenhaVazio;
	@NotBlank
	public static String agenciaNaoExiste;
	@NotBlank
	public static String contaNaoExiste;
	@NotBlank
	public static String contaSenhaNaoConfere;
	
	public static void setTituloVazio(String tituloVazio) {
		MSGProperties.tituloVazio = tituloVazio;
	}
	public static void setNomeExiste(String nomeExiste) {
		MSGProperties.nomeExiste = nomeExiste;
	}
	public static void setSalvo(String salvo) {
		MSGProperties.salvo = salvo;
	}
	public static void setSenhasDiferentes(String senhasDiferentes) {
		MSGProperties.senhasDiferentes = senhasDiferentes;
	}
	public static void setNovaSenhaConfirmarVazio(String novaSenhaConfirmarVazio) {
		MSGProperties.novaSenhaConfirmarVazio = novaSenhaConfirmarVazio;
	}
	public static void setNovaSenhaVazio(String novaSenhaVazio) {
		MSGProperties.novaSenhaVazio = novaSenhaVazio;
	}
	public static void setLoginNaoRealizado(String loginNaoRealizado) {
		MSGProperties.loginNaoRealizado = loginNaoRealizado;
	}
	public static void setDadosVazios(String dadosVazios) {
		MSGProperties.dadosVazios = dadosVazios;
	}
	public static void setSenhaInvalida(String senhaInvalida) {
		MSGProperties.senhaInvalida = senhaInvalida;
	}
	public static void setSenhaRedefinida(String senhaRedefinida) {
		MSGProperties.senhaRedefinida = senhaRedefinida;
	}
	public static void setConfirmarSenhaErrado(String confirmarSenhaErrado) {
		MSGProperties.confirmarSenhaErrado = confirmarSenhaErrado;
	}
	public static void setSenhaVazio(String senhaVazio) {
		MSGProperties.senhaVazio = senhaVazio;
	}
	public static void setConfirmarSenhaVazio(String confirmarSenhaVazio) {
		MSGProperties.confirmarSenhaVazio = confirmarSenhaVazio;
	}
	public static void setEmailExiste(String emailExiste) {
		MSGProperties.emailExiste = emailExiste;
	}
	public static void setEmailVazio(String emailVazio) {
		MSGProperties.emailVazio = emailVazio;
	}
	public static void setRecuperarSenhaEmailNaoExiste(String recuperarSenhaEmailNaoExiste) {
		MSGProperties.recuperarSenhaEmailNaoExiste = recuperarSenhaEmailNaoExiste;
	}
	public static void setRecuperarSenhaOK(String recuperarSenhaOK) {
		MSGProperties.recuperarSenhaOK = recuperarSenhaOK;
	}
	public static void setUsuarioInserido(String usuarioInserido) {
		MSGProperties.usuarioInserido = usuarioInserido;
	}
	public static void setUsuarioAtualizado(String usuarioAtualizado) {
		MSGProperties.usuarioAtualizado = usuarioAtualizado;
	}
	public static void setUsuarioExcluido(String usuarioExcluido) {
		MSGProperties.usuarioExcluido = usuarioExcluido;
	}
	public static void setEmailInvalido(String emailInvalido) {
		MSGProperties.emailInvalido = emailInvalido;
	}
	public static void setNomeVazio(String nomeVazio) {
		MSGProperties.nomeVazio = nomeVazio;
	}
	public static void setAssuntoEmailRedefinicaoSenha(String assuntoEmailRedefinicaoSenha) {
		MSGProperties.assuntoEmailRedefinicaoSenha = assuntoEmailRedefinicaoSenha;
	}
	public static void setExcluido(String excluido) {
		MSGProperties.excluido = excluido;
	}
	public static void setCpfVazio(String cpfVazio) {
		MSGProperties.cpfVazio = cpfVazio;
	}
	public static void setTelefoneVazio(String telefoneVazio) {
		MSGProperties.telefoneVazio = telefoneVazio;
	}
	public static void setCelularVazio(String celularVazio) {
		MSGProperties.celularVazio = celularVazio;
	}
	public static void setCpfJaExiste(String cpfJaExiste) {
		MSGProperties.cpfJaExiste = cpfJaExiste;
	}
	public static void setCpfInvalido(String cpfInvalido) {
		MSGProperties.cpfInvalido = cpfInvalido;
	}
	
}
