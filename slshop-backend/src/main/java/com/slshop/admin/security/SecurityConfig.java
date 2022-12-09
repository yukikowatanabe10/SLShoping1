package com.slshop.admin.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .failureUrl("/login?error")
                .permitAll()
        ).logout(logout -> logout
                .logoutSuccessUrl("/login")
        ).authorizeHttpRequests(authz -> authz
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                // auth example
//                .mvcMatchers("/admin").hasAuthority("ADMIN")
                .anyRequest().authenticated()
        );
//        .csrf(csrf -> csrf
//                .disable()
//    //          .ignoringAntMatchers("/login")
//    //          .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//        ).exceptionHandling(exhandling -> exhandling
//                .authenticationEntryPoint(new BasicAuthenticationEntryPoint())
//        );

        return http.build();
    }

}
