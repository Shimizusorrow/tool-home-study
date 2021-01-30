package com.example.security.config.security.jwt;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collections;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-30 09:09
 */
public class JwtAuthentication extends AbstractAuthenticationToken {
    private Object principal;

    private final String token;

    public JwtAuthentication(String token) {
        super(Collections.emptyList());
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    public void setPrincipal(Object principal) {
        this.principal = principal;
    }
}
