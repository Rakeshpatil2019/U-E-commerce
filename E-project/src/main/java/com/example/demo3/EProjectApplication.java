package com.example.demo3;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EProjectApplication.class, args);
	}

	@Bean
	public ModelMapper mapper()
	{
		return new ModelMapper();
	}
	
	
}
