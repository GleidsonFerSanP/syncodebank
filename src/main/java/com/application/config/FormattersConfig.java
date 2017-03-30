package com.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FormattersConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private DateFormatter dateFormatter;
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
	    registry.addFormatter(dateFormatter);
	}

	@Bean
	public DateFormatter dateFormatter() {
	    return new DateFormatter("dd-MM-yyyy HH:mm");
	}
}
