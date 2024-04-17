package com.jersson.arrivasplata.swtvap.security;

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
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(x -> x.disable())
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/analytics/**").hasRole("ADMIN")
                        .requestMatchers("/api/newsletter-subscriptions/**").hasRole("ADMIN")
                        .requestMatchers("/api/marketing-campaigns/**").hasRole("ADMIN")
                        .requestMatchers("/api/cart-details/**").hasRole("ADMIN")
                        .requestMatchers("/api/carts/**").hasRole("ADMIN")
                        .requestMatchers("/api/units/**").hasRole("ADMIN")
                        .requestMatchers("/api/categories/**").hasRole("ADMIN")
                        .requestMatchers("/api/category-catalogs/**").hasRole("ADMIN")
                        .requestMatchers("/api/catalogs/**").hasRole("ADMIN")
                        .requestMatchers("/api/dispatches/**").hasRole("ADMIN")
                        .requestMatchers("/api/orders-amounts/**").hasRole("ADMIN")
                        .requestMatchers("/api/orders/**").hasRole("ADMIN")
                        .requestMatchers("/api/orders-details/**").hasRole("ADMIN")
                        .requestMatchers("/api/orders-transactions/**").hasRole("ADMIN")
                        .requestMatchers("/api/product-discounts/**").hasRole("ADMIN")
                        .requestMatchers("/api/product-catalogs/**").hasRole("ADMIN")
                        .requestMatchers("/api/product-categories/**").hasRole("ADMIN")
                        .requestMatchers("/api/products/**").hasRole("ADMIN")
                        .requestMatchers("/api/product-images/**").hasRole("ADMIN")
                        .requestMatchers("/api/product-parameters/**").hasRole("ADMIN")
                        .requestMatchers("/api/product-providers/**").hasRole("ADMIN")
                        .requestMatchers("/api/product-units/**").hasRole("ADMIN")
                        .requestMatchers("/api/clients/**").hasRole("ADMIN")
                        .requestMatchers("/api/providers/**").hasRole("ADMIN")
                        .requestMatchers("/api/comments/**").hasRole("ADMIN")
                        .requestMatchers("/api/contacts/**").hasRole("ADMIN")
                        .requestMatchers("/api/reviews/**").hasRole("ADMIN")
                        .requestMatchers("/api/parameters/**").hasRole("ADMIN")
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
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(x -> x.jwt(jwt -> jwt.decoder(jwtDecoder())
                        .jwtAuthenticationConverter(jwtAuthenticationConverter())));

        return http.build();
    }


}