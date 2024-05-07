package com.example.userregistration.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeHttpRequests ->
                authorizeHttpRequests
                    .requestMatchers("/register", "/forgot-password", "/reset-password").permitAll() // Allow access without authentication
                    .requestMatchers("/admin/**").hasRole("ADMIN") // Require ADMIN role for paths starting with /admin
                    .requestMatchers("/user/**").hasRole("USER") // Require USER role for paths starting with /user
                    .anyRequest().authenticated() // Require authentication for all other requests
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .permitAll()
            )
            .logout(logout ->
                logout
                    .permitAll()
            );

        return http.build();
    }
    
}