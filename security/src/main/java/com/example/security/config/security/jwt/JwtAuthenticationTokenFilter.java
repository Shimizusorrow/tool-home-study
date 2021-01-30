package com.example.security.config.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-30 08:26
 */

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    private final JwtProvider jwtProvider;

    public JwtAuthenticationTokenFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String tokenKey = JwtProvider.JWT_HEADER_KEY;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Expose-Headers", "content-type" + "," + tokenKey);
        response.addHeader("Access-Control-Expose-Headers", "content-type");
        response.setHeader("Access-Control-Allow-Headers", "content-type, authorization" + "," + tokenKey);

        String token = request.getHeader(JwtProvider.JWT_HEADER_KEY);

        if (token != null && !token.isEmpty()) {
            Authentication authenticate = jwtProvider.authenticate(new JwtAuthentication(token));
            if (authenticate != null) {
                SecurityContext context = SecurityContextHolder.getContext();
                context.setAuthentication(authenticate);
            }
        }
        filterChain.doFilter(request, response);

    }
}
