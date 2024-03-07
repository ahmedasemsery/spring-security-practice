package com.example.springsecuritypractice.config;

import com.example.springsecuritypractice.config.filters.CustomSecurityFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomSecurityFilter customSecurityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .addFilterAt(customSecurityFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(registry -> registry.anyRequest().authenticated())
                .build();
    }
}
