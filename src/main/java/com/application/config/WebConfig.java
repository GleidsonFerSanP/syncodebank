package com.application.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.application.cors.CORSFilter;
import com.application.security.custom.filter.AuthenticatorFilter;
import com.application.security.custom.provider.ContaAuthenticatorProviderImpl;
import com.application.security.custom.provider.ICustomAuthenticatorProvider;
import com.application.security.custom.provider.UsuarioAuthenticatorProviderImpl;
import com.application.security.custom.util.AuthInterceptor;
import com.extra.properties.ProjectProperties;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry r) {
		String myExternalFilePath = "file:///"+ProjectProperties.arquivosAbsoluto;

		r.addResourceHandler("/"+ProjectProperties.arquivosRelativo+"/**").addResourceLocations(myExternalFilePath);

		super.addResourceHandlers(r);
	}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
	    PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
	    resolver.setPageParameterName("page.page");
	    resolver.setSizeParameterName("page.size");
	    resolver.setOneIndexedParameters(true);
	    argumentResolvers.add(resolver);
	    super.addArgumentResolvers(argumentResolvers);
	}

	@Bean
	public AuthInterceptor getAuthInterceptor(){
		return new AuthInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getAuthInterceptor()).addPathPatterns("/rest/mobile/**");
	}


	@Bean
	public DomainClassConverter<FormattingConversionService> domainClassConverter(
			FormattingConversionService conversionService) {
		return new DomainClassConverter<FormattingConversionService>(conversionService);
	}

	@Bean
	public static PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/home");
	}

	@Bean
	public CORSFilter corsFilter() {
		return new CORSFilter();
	}

	@Bean
	public AuthenticatorFilter authenticatorFilter() {
		return new AuthenticatorFilter();
	}

	@Bean(name = "usuarioAuthenticatorProvider")
	public ICustomAuthenticatorProvider usuarioAuthenticatorProvider() {
		return new UsuarioAuthenticatorProviderImpl();
	}

	@Bean(name = "contaAuthenticatorProvider")
	public ICustomAuthenticatorProvider contaAuthenticatorProvider() {
		return new ContaAuthenticatorProviderImpl();
	}

}
