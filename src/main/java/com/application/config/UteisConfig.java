package com.application.config;

import java.util.Random;
import java.util.Timer;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.application.security.custom.util.TokenService;

@Configuration
public class UteisConfig extends WebMvcConfigurerAdapter {
	
	@Bean
    public Random random() {
       return new Random();
    }
	
	@Bean
	public Timer timer() {
		return new Timer();
	}
	
	@Bean
	public TokenService tokenService() {
		return new TokenService();
	}
	
	@Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("10MB");
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }
}
