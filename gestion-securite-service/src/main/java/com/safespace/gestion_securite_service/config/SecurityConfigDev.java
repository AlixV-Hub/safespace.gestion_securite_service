package com.safespace.gestion_securite_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile("dev") // Active uniquement en profil dev
public class SecurityConfigDev {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Autorise tout en dev
                )
                .csrf(csrf -> csrf.disable()); // Désactive CSRF pour les tests

        return http.build();
    }
}

// ce fichier sert à contourner spring security lors du dev car par défaut toutes les routes sont protegées mdp ou bloqués
