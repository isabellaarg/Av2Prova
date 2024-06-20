package com.example.ProvaAww.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * A classe ProvaAwwApplication serve como o ponto de entrada para a aplicação Spring Boot.
 * Ela habilita a auto-configuração, varredura de componentes e configuração de repositórios MongoDB.
 */
@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableMongoRepositories(basePackages = "com.example.ProvaAww.repository")
public class ProvaAwwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaAwwApplication.class, args);
	}

}
