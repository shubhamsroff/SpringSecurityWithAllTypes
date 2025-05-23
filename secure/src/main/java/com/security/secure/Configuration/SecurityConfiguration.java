package com.security.secure.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.security.web.SecurityFilterChain;

import com.security.secure.Repository.UserRepository;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception{
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF (only if using JWT)
            .cors(cors -> cors.disable())  // Configure CORS properly instead of disabling it
            .authorizeHttpRequests(auth -> auth
    .requestMatchers("/admin").hasAuthority("ROLE_ADMIN")  // Strictly requires ROLE_ADMIN
    .requestMatchers("/user").hasAuthority("ROLE_USER")    // Strictly requires ROLE_USER
    .anyRequest().authenticated())
            .formLogin(form -> form.permitAll())  // Enable form-based login
            .logout(logout -> logout.permitAll());
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    // @Bean
    // public UserDetailsService getUserDetailsService(){
    //     UserDetails user=User.builder().username("Shubham").password(getPasswordEncoder().encode("shubh")).authorities("ROLE_USER")
    //     .build();
    //     return new InMemoryUserDetailsManager(user);
    // }


    @Bean
    public UserDetailsService getUserDetailsService(){
        UserDetailsService userDetailsService = (username) -> 
        userRepository.findByUsername(username)
            .map(myUser->
            User.builder().username(myUser.getUsername())
            .password(myUser.getPassword())
            .roles(myUser.getRoles().split(",")).build())
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));    
        return userDetailsService;
    }
}
