package com.agsr.monitor_sensors.config;

import com.agsr.monitor_sensors.service.security.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**")
                        .permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/sensors")
                        .hasAnyRole("ADMINISTRATOR", "VIEWER")
                        .requestMatchers(HttpMethod.GET, "/api/v1/sensors/search")
                        .hasAnyRole("ADMINISTRATOR", "VIEWER")
                        .requestMatchers(HttpMethod.POST, "/api/v1/sensors")
                        .hasRole("ADMINISTRATOR")
                        .requestMatchers(HttpMethod.GET, "/api/v1/sensors/**")
                        .hasRole("ADMINISTRATOR")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/sensors/**")
                        .hasRole("ADMINISTRATOR")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/sensors/**")
                        .hasRole("ADMINISTRATOR")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
