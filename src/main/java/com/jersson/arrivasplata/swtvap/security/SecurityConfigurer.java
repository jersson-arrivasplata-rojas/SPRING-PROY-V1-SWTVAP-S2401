package com.jersson.arrivasplata.swtvap.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.jersson.arrivasplata.swtvap.api.auth.services.BlackListService;
import com.jersson.arrivasplata.swtvap.utils.JwtUtil;

@Configuration
@EnableMethodSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer {

    private UserDetailsService userDetailsService;

    public SecurityConfigurer(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return new JwtUtil().jwtDecoder();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
        converter.setAuthoritiesClaimName("authorities");
        converter.setAuthorityPrefix(""); // If you have already prefixed roles with 'ROLE_'

        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
            List<String> roles = jwt.getClaimAsStringList("roles");
            return roles.stream()
                    .map(SimpleGrantedAuthority::new) // Convert role to SimpleGrantedAuthority
                    .collect(Collectors.toList());
        });
        return jwtConverter;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        List<String> allowedOrigins = new ArrayList<>(Arrays.asList(
                "http://localhost:4200/#/",
                "https://localhost:4200/#/",
                "http://localhost/#/",
                "https://localhost/#/",
                "http://209.38.134.10/#/",
                "https://209.38.134.10/#/",
                "http://chascaperuart.com/#/",
                "https://chascaperuart.com/#/",
                "http://localhost:4200",
                "https://localhost:4200",
                "http://localhost",
                "https://localhost",
                "http://209.38.134.10",
                "https://209.38.134.10",
                "http://chascaperuart.com",
                "https://chascaperuart.com"
        ));

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(allowedOrigins); // Or specify your origins
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*")); // Or specify your headers
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @SuppressWarnings("deprecation")
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, BlackListService blacklistService) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .addFilterBefore(new TokenBlacklistFilter(blacklistService), UsernamePasswordAuthenticationFilter.class)
                .csrf(x -> x.disable())
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/w-analytics/**").permitAll()
                        .requestMatchers("/api/w-catalogs/**").permitAll()
                        .requestMatchers("/api/w-categories/**").permitAll()
                        .requestMatchers("/api/w-comments/**").permitAll()
                        .requestMatchers("/api/w-contacts/**").permitAll()
                        .requestMatchers("/api/w-newsletter-subscriptions/**").permitAll()
                        .requestMatchers("/api/w-orders/**").permitAll()
                        .requestMatchers("/api/w-parameters/**").permitAll()
                        .requestMatchers("/api/w-products/**").permitAll()
                        .requestMatchers("/api/w-reviews/**").permitAll()
                        .requestMatchers("/swtvap/**").permitAll()
                        .requestMatchers("/swtvap-api-product/v3/api-docs").permitAll()
                        .requestMatchers("/swagger-ui.html").permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(x -> x.jwt(jwt -> jwt.decoder(jwtDecoder())
                        .jwtAuthenticationConverter(jwtAuthenticationConverter())));

        return http.build();
    }

}