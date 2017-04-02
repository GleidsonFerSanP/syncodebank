package com.application.security.custom.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.application.security.custom.provider.ICustomAuthenticatorProvider;
import com.application.security.custom.util.TokenService;
import com.extra.properties.MSGProperties;

public class AuthenticatorFilter implements Filter {

	@Autowired
	@Qualifier(value = "contaAuthenticatorProvider")
	private ICustomAuthenticatorProvider contaAuthenticatorProvider;

	@Autowired
	@Qualifier(value = "usuarioAuthenticatorProvider")
	private ICustomAuthenticatorProvider usuarioAuthenticatorProvider;
	
	@Autowired
	private TokenService tokenService;

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

	@SuppressWarnings("deprecation")
	public void doFilter(ServletRequest r, ServletResponse response, FilterChain c) throws IOException, ServletException {
		String token = null;
		HttpServletRequest httpRequest = (HttpServletRequest) r;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String uri = httpRequest.getRequestURI();
		
		if(uri.contains("/login/cliente"))
			c.doFilter(httpRequest, response);
		
		token = tokenService.getTokenInRequest(httpRequest);
		
		if(!uri.contains("/login/cliente"))
			if (contaAuthenticatorProvider.checkIfAuthenticate(token))
				c.doFilter(httpRequest, response);
			else
				httpResponse.setStatus(401, MSGProperties.loginNaoRealizado);
		
	}

}
