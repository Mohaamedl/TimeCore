package com.example.timecore;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class TimecoreApplication {

	public static void main(String[] args) {
		// import environment variables from .env
		Dotenv dotenv = Dotenv.configure()
				.filename(".env")
				.load();

		System.setProperty("DB_MYSQL_URL", dotenv.get("DB_MYSQL_URL"));
		System.setProperty("DB_MYSQL_USERNAME", dotenv.get("DB_MYSQL_USERNAME"));
		System.setProperty("DB_MYSQL_PASSWORD", dotenv.get("DB_MYSQL_PASSWORD"));
		SpringApplication.run(TimecoreApplication.class, args);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/public/**").permitAll() // Permite acesso público a /public/**
						.anyRequest().authenticated() // Requer autenticação para todas as outras rotas
				)
				.formLogin(login -> login
						.loginPage("/login") // Página de login personalizada
						.defaultSuccessUrl("/home", true) // Página de sucesso após login
						.permitAll()
				)
				.logout(logout -> logout
						.logoutUrl("/logout") // Define a URL para logout
						.logoutSuccessUrl("/login?logout") // Página após o logout
						.permitAll()
				);

		return http.build();
	}
}
