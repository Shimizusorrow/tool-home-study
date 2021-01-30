package com.example.security.config.security;

import com.example.security.config.security.jwt.JwtAuthenticationSuccessHandler;
import com.example.security.config.security.jwt.JwtAuthenticationTokenFilter;
import com.example.security.config.security.jwt.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-29 16:21
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("UserDomainServiceImpl")
    private final UserDetailsService userDetailsService;

    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    private final JwtAuthenticationSuccessHandler jwtAuthenticationSuccessHandler;

    private final AuthFailureHandler authFailureHandler;

    private final JwtProvider jwtProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(jwtProvider)
                // 设置UserDetailsService
                .userDetailsService(userDetailsService)
                // 使用BCrypt进行密码的hash --不加密
                .passwordEncoder(passwordEncoder());
    }

    // 装载 无加密
    @Bean(name = "securityPasswordEncoder")
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    // 由于使用的是JWT，我们这里不需要csrf
                .csrf().disable()
                // 基于token，所以不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .disable()
                .and()
                .authorizeRequests()
                //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // 允许对于网站静态资源的无授权访问
//                .antMatchers("/**").permitAll()
                // 对于获取token的rest api要允许匿名访问
                .antMatchers("/auth/**").permitAll()
                //除上面之外的所有请求全都需要鉴权认证
                //.anyRequest().authenticated();
                .antMatchers("/swagger-ui.html")
                .authenticated()
                .and().
                formLogin(login -> {
                    login.loginProcessingUrl("/login")
                            .successHandler(jwtAuthenticationSuccessHandler)
                            .failureHandler(authFailureHandler);
                });

        //禁用缓存
        http.headers().cacheControl();

        // 添加JWT filter
        http
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
