package com.example.security.config.security.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-30 09:04
 */
@Configuration
public class JwtConfig {
    @Bean
    public JwtProperties jwtProperties() {
        return new JwtProperties();
    }

    @Bean
    public JwtProvider jwtAuthenticationProvider(JwtProperties properties,
                                                 JwtSecurityUserParser parser) {
        return new JwtProvider(parser, properties);
    }

    @Bean
    public JwtAuthenticationSuccessHandler authenticationSuccessHandler(JwtSecurityUserParser parser,
                                                                        JwtProvider provider) {
        return new JwtAuthenticationSuccessHandler(parser, provider);
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtFilter(JwtProvider provider) {
        return new JwtAuthenticationTokenFilter(provider);
    }
}
