package com.project.apis.config;

import com.project.apis.models.user.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /*
    *  ruta que son segura
    * */
    private static final String[] SECURITY_URLS = {"/apis/anime/**"};

    /*
    *  ruta que son no segura
    * */
    private static final String[] UN_SECURITY_URLS = {"/apis/anime/all", "/apis/anime/{id}", "/apis/anime/title/**",
    "/apis/anime/author/**", "/apis/user/**", "/apis/user/{id}"};
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests().requestMatchers(UN_SECURITY_URLS)
                .permitAll().and().authorizeHttpRequests().requestMatchers(SECURITY_URLS)
                .hasAnyAuthority("ADMIN").anyRequest()
                .authenticated().and().formLogin();
        return http.build();
    }


}
