package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.configuration.SwaggerConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@Import(SwaggerConfig.class)
@EnableMongoRepositories
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
