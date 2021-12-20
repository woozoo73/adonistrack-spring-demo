package com.woozooha.demo;

import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AdonistrackSpringDemoApplication {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(AdonistrackSpringDemoApplication.class);

	public static void main(String[] args) {
		initDb();
		SpringApplication.run(AdonistrackSpringDemoApplication.class, args);

		log.info("http://localhost:8080/greeting/1");
		log.info("http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/");
		log.info("http://localhost:8080/webjars/adonistrack-ui/html/invocations.html");
	}

	@SneakyThrows
	private static void initDb() {
		MariaDB4jSpringService mariaDB4jSpringService = new MariaDB4jSpringService();
		mariaDB4jSpringService.setDefaultPort(3309);
		mariaDB4jSpringService.start();

		mariaDB4jSpringService.getDB().createDB("demo");
		mariaDB4jSpringService.getDB().source("schema.sql");
		mariaDB4jSpringService.getDB().source("data.sql");
	}

}
