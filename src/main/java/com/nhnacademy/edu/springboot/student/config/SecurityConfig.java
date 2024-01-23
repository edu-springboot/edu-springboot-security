package com.nhnacademy.edu.springboot.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

// TODO #2: security config
@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig {
    // TODO #3: SecurityFilterChain 을 반환하는 Bean 등록
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasAuthority("ROLE_ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/private-project/**")).hasAnyAuthority("ROLE_ADMIN", "ROLE_MEMBER")
                .requestMatchers(new AntPathRequestMatcher("/project/**")).authenticated()
                .requestMatchers(new AntPathRequestMatcher("/redirect-index")).authenticated()
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .and()
            .logout().logoutUrl("/logout")
                .and()
            .csrf()
                .disable()
            .sessionManagement()
                .sessionFixation()
                    .none()
                .and()
            .build();
    }

    // TODO #4: InMemoryUserDetailsManager 반환하는 Bean 등록
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin")
                .authorities("ROLE_ADMIN")
                .build();

        UserDetails member = User.withUsername("member")
                .password("{noop}member")
                .authorities("ROLE_MEMBER")
                .build();

        UserDetails guest = User.withUsername("guest")
            .password("{noop}guest")
            .authorities("ROLE_GUEST")
            .build();

        return new InMemoryUserDetailsManager(admin, member, guest);
    }

}
