package com.form.login.form_login.Configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.form.login.form_login.Entity.MyUser;
import com.form.login.form_login.Repository.MyUserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private MyUserRepository userRepository;
	@Bean
	public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(
						authz -> authz.requestMatchers("/signup", "/login","examp").permitAll().anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/home")
						.failureUrl("/login?error=true").permitAll())
				.logout(logout -> logout.logoutSuccessUrl("/login?logout=true").permitAll()).build();

	}
	
	@Bean
     public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    } 

	
	public void registerUser(MyUser user) {
		user.setPassword(bcryptPasswordEncoder().encode(user.getPassword()));
		user.setRole("USER");
		userRepository.save(user);
	}
}