package com.ansible;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AnsibleTestAppApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(AnsibleTestAppApplication.class, args);
		
	}
	@Override  
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
	{  
	return application.sources(AnsibleTestAppApplication.class);  
	}   

}
