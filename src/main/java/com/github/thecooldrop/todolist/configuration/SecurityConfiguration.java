package com.github.thecooldrop.todolist.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain oidcAuthenticationConfiguration(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(c -> c.anyRequest().authenticated())
                .oauth2ResourceServer(oidc -> oidc.jwt(Customizer.withDefaults()))
                .csrf(c -> c.disable())
                .build();
    }


}
