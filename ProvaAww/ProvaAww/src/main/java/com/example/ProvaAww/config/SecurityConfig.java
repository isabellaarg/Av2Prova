package com.example.ProvaAww.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * A classe SecurityConfig configura a segurança da aplicação Spring Boot.
 * Ela desabilita a proteção CSRF, define regras de autorização para requisições HTTP,
 * e configura autenticação básica HTTP.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configura a cadeia de filtros de segurança.
     *
     * @param http o objeto HttpSecurity que permite configurar a segurança baseada na web.
     * @return o filtro de segurança configurado.
     * @throws Exception se houver um erro durante a configuração.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorize -> authorize
                        .antMatchers(HttpMethod.POST, "/register").permitAll()
                        .antMatchers(HttpMethod.POST, "/login").permitAll()
                        .antMatchers(HttpMethod.GET, "/username/**").permitAll()
                        .antMatchers("/admin/**").hasRole("ADMIN")
                        .antMatchers("/manager/products").hasRole("MANAGER")
                        .antMatchers("/seller/orders").hasRole("SELLER")
                        .antMatchers("/customer/products").hasRole("CUSTOMER")
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /**
     * Configura o serviço de detalhes do usuário em memória com dois usuários: um usuário comum e um administrador.
     *
     * @return o serviço de detalhes do usuário configurado.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("joao")
                .password(passwordEncoder().encode("4321"))
                .roles("CUSTOMER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();
        UserDetails gerente = User.builder()
                .username("harry")
                .password(passwordEncoder().encode("1234"))
                .roles("MANAGER")
                .build();
        UserDetails vendedor = User.builder()
                .username("louis")
                .password(passwordEncoder().encode("1234"))
                .roles("SELLER")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    /**
     * Configura o codificador de senhas usando BCrypt.
     *
     * @return o codificador de senhas configurado.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

