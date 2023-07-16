package org.sid.offregame.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .formLogin().loginPage("/login").permitAll()
                .and()
                .csrf().ignoringRequestMatchers("/toggle")
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/css/**, /js/**, /assets/**,/vendors/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password("{noop}password").roles("USER").build(),
                User.withUsername("user2").password("{noop}password").roles("USER","ADMIN").build()
        );
    }

}
