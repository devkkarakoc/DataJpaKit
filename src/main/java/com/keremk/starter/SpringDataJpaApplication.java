package com.keremk.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.keremk.configuration.GlobalProperties;

@SpringBootApplication
@EntityScan(basePackages = { "com.keremk" })
@ComponentScan(basePackages = { "com.keremk" })
@EnableJpaRepositories(basePackages = { "com.keremk" })
@EnableConfigurationProperties(value = GlobalProperties.class)
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
