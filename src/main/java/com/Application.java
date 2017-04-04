package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.github.ulisesbocchio.jar.resources.JarResourceLoader;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
        .sources(Application.class)
        .resourceLoader(new JarResourceLoader())
        .run(args);
	}
	
	
}
