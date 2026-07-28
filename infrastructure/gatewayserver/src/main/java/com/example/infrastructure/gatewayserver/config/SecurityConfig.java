package com.example.infrastructure.gatewayserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        PathPatternRequestMatcher.Builder matcherBuilder = PathPatternRequestMatcher.withDefaults();

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(matcherBuilder.matcher(HttpMethod.GET, "/actuator/health")).permitAll()
                        .requestMatchers(matcherBuilder.matcher(HttpMethod.GET, "/actuator/health/**")).permitAll()
                        .requestMatchers(matcherBuilder.matcher(HttpMethod.GET, "/api/v1/posts")).permitAll()
                        .requestMatchers(matcherBuilder.matcher(HttpMethod.GET, "/api/v1/posts/**")).permitAll()
                        .requestMatchers(matcherBuilder.matcher(HttpMethod.GET, "/api/v1/profiles")).permitAll()
                        .requestMatchers(matcherBuilder.matcher(HttpMethod.GET, "/api/v1/profiles/**")).permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults())
                );

        return http.build();
    }
}