package com.example.security.config.security.jwt;


import com.example.security.config.security.SecurityUserParser;
import com.example.security.util.JsonUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Jwt 认证成功处理
 * Created Date : 2020/09/01
 *
 * @author zzk
 */
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtProvider provider;
    private final SecurityUserParser parser;
    private final static ObjectMapper objectMapper = JsonUtils.getInstance();


    public JwtAuthenticationSuccessHandler(SecurityUserParser parser,
                                           JwtProvider provider) {
        this.parser = parser;
        this.provider = provider;
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        Object user = authentication.getPrincipal();
        String token = provider.writeToken((UserDetails) authentication.getPrincipal());
        if (user instanceof UserDetails) {
            user = parser.transferToSecurityUser((UserDetails) user);
        }
        response.setHeader(JwtProvider.JWT_HEADER_KEY, token);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ServletOutputStream outputStream = response.getOutputStream();
        objectMapper.writeValue(response.getOutputStream(), user);
        outputStream.flush();
    }
}
