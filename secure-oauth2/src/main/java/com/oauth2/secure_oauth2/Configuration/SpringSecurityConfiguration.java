package com.oauth2.secure_oauth2.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception{

        return http.authorizeHttpRequests(auth->auth.requestMatchers("/public")
        .permitAll().anyRequest().authenticated()).build();
  
    }
    
}
