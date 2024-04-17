package com.jersson.arrivasplata.swtvap.security;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jersson.arrivasplata.swtvap.api.auth.services.BlackListService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TokenBlacklistFilter extends OncePerRequestFilter {

    private final BlackListService blacklistService;
    private final AntPathMatcher pathMatcher = new AntPathMatcher();
    private final String[] adminPaths = {
            "/api/admin/**",
            "/api/analytics/**",
            "/api/newsletter-subscriptions/**",
            "/api/marketing-campaigns/**",
            "/api/cart-details/**",
            "/api/carts/**",
            "/api/units/**",
            "/api/categories/**",
            "/api/category-catalogs/**",
            "/api/catalogs/**",
            "/api/dispatches/**",
            "/api/orders-amounts/**",
            "/api/orders/**",
            "/api/orders-details/**",
            "/api/orders-transactions/**",
            "/api/product-discounts/**",
            "/api/product-catalogs/**",
            "/api/product-categories/**",
            "/api/products/**",
            "/api/product-images/**",
            "/api/product-parameters/**",
            "/api/product-providers/**",
            "/api/product-units/**",
            "/api/clients/**",
            "/api/providers/**",
            "/api/comments/**",
            "/api/contacts/**",
            "/api/reviews/**",
            "/api/parameters/**"
    };

    public TokenBlacklistFilter(BlackListService blacklistService) {
        this.blacklistService = blacklistService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        String requestPath = request.getServletPath();
        boolean isMatch = false;
        for (String adminPath : adminPaths) {
            if (pathMatcher.match(adminPath, requestPath)) {
                isMatch = true;
                break;
            }
        }
        if (isMatch && token != null && blacklistService.isBlacklisted(token)) {
            SecurityContextHolder.clearContext();
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is blacklisted");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
