package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.github.ulisesbocchio.jar.resources.JarResourceLoader;

@SpringBootApplication
public class AdminApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AdminApplication.class, args);
		
		new SpringApplicationBuilder()
        .sources(AdminApplication.class)
        .resourceLoader(new JarResourceLoader())
        .run(args);
	}
	
	
}
