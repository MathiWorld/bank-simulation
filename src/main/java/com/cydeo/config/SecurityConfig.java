package com.cydeo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final AuthSuccesHandler authSuccessHandler;

    public SecurityConfig(AuthSuccesHandler authSuccessHandler) {
        this.authSuccessHandler = authSuccessHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http){
        return http
                .authorizeRequests()
                .antMatchers("/account/**").hasAuthority("Admin")
                .antMatchers("/transaction/**").hasAuthority("Admin","Cashier")
                .antMatchers(
                        "/",
                        "/login",
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(authSuccessHandler)
                .failureUrl("/")

    }

}
