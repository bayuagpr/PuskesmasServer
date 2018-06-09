package com.puskesmas.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "securityAuditorAware")
public class ServerPuskesmasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerPuskesmasApplication.class, args);
	}
}
