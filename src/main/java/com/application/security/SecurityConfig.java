package com.application.security;

import javax.annotation.Resource;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import com.application.cors.CORSFilter;
import com.application.security.custom.filter.AuthenticatorFilter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource
	private CORSFilter corsFilter;

	@Resource
	private AuthenticatorFilter authenticatorFilter;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/api/v1/**")
		.antMatchers("/public/**");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// CORS
		http.addFilterBefore(corsFilter, ChannelProcessingFilter.class);

		// Authenticator filter
		http.addFilterBefore(authenticatorFilter, ChannelProcessingFilter.class);
		
		http
		.authorizeRequests()
		.anyRequest().authenticated();

	}

}
