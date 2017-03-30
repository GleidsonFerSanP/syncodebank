package com.extra.properties;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(locations = "classpath:project.properties", ignoreUnknownFields = false, prefix = "project")
public class ProjectProperties {

	@NotBlank
	public static String arquivosRelativo;
	@NotBlank
	public static String arquivosAbsoluto;
	@NotBlank
	public static String nomeProjeto;
	@NotBlank
    public static String baseUrl;
	@NotBlank
	public static String hoursMinus;

	public static void setNomeProjeto(String nomeProjeto) {
		ProjectProperties.nomeProjeto = nomeProjeto;
	}
	public static void setBaseUrl(String baseUrl) {
		ProjectProperties.baseUrl = baseUrl;
	}
	public static void setArquivosRelativo(String arquivosRelativo) {
		ProjectProperties.arquivosRelativo = arquivosRelativo;
	}
	public static void setArquivosAbsoluto(String arquivosAbsoluto) {
		ProjectProperties.arquivosAbsoluto = arquivosAbsoluto;
	}
	public static String getHoursMinus() {
		return hoursMinus;
	}
	public static void setHoursMinus(String hoursMinus) {
		ProjectProperties.hoursMinus = hoursMinus;
	}
	
}
