package com.auditoriasys.SysAuditorias.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer{
    
	/*
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        	.csrf().disable()
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/api/**").permitAll()
                    .anyRequest().permitAll()
            );

        return http.build();
    }
*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
