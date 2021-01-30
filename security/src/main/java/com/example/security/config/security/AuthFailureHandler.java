package com.example.security.config.security;

import com.example.security.util.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-30 11:01
 */
@Configuration
@Slf4j
public class AuthFailureHandler implements AuthenticationFailureHandler {

    private final static ObjectMapper objectMapper = JsonUtils.getInstance();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//        log.error(String.format("AuthenticationException ERROR : [%s]", e.getMessage()));
        response.setStatus(AuthResponse.errorResponse.code);
        response.setContentType("application/json");
        objectMapper.writeValue(response.getOutputStream(), AuthResponse.errorResponse);

    }

    private static class AuthResponse {
        private Integer code;
        private String message;
        public static final AuthResponse errorResponse = new AuthResponse();

        static {
            errorResponse.code = 400;
            errorResponse.message = "用户名或密码错误";
        }

        private AuthResponse() {

        }
    }
}
