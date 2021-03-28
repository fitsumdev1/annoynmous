package com.fitsum.annonymous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing 
@EnableEurekaClient
@EnableCaching
public class AnnoynmousApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnoynmousApplication.class, args);
	}

}
         