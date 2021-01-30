package com.example.security.config.security.jwt;

import com.example.security.util.JsonUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Shimizu
 * @description
 * @date 2021-01-30 09:03
 */
public class JwtProvider implements AuthenticationProvider {
    /**
     * JWT 暴露 token 的 header 关键字名称
     */
    public static final String JWT_HEADER_KEY = "x-auth-token";

    /**
     * 默认的 JWT 用户变量
     */
    public static final String DEFAULT_JWT_USER_KEY = "user";

    /**
     * jwt 的用户关键字，用于 jwt 签名的生成与解析
     */
    private String jwtUserKey = DEFAULT_JWT_USER_KEY;

    private final Logger log = LoggerFactory.getLogger(JwtProvider.class);

    private final JwtSecurityUserParser parser;

    private final JwtProperties jwtProperties;

    private static final ObjectMapper objectMapper = JsonUtils.getInstance();


    public JwtProvider(JwtSecurityUserParser parser, JwtProperties jwtProperties) {
        this.parser = parser;
        this.jwtProperties = jwtProperties;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            JwtAuthentication au = (JwtAuthentication) authentication;
            String token = (String) au.getCredentials();
            if (tokenWithoutExpiration(token)) {
                UserDetails principle = this.getPrinciple(token);
                au.setPrincipal(principle);
                au.setAuthenticated(true);
            }
            return au;
        } catch (Exception e) {
            log.debug("jwt 解析出现问题 : {}", e.toString());
            return null;
        }
    }

    private boolean tokenWithoutExpiration(String token) {
        Jws<Claims> claims = Jwts
                .parser()
                .setSigningKey(jwtProperties.getSalt())
                .parseClaimsJws(token);
        Claims body = claims.getBody();
        return !body.getExpiration().before(new Date());
    }

    /**
     * 传入认证后的用户,生成 JWT
     */
    public String writeToken(UserDetails user) {
        Object principle = parser.transferToSecurityUser(user);
        Date now = new Date();
        Date expiration = new Date(now.getTime() + this.jwtProperties.getExpirationTime());

        Map<String, Object> map = new HashMap<>();
        map.put(jwtUserKey, principle);

        return Jwts
                .builder()
                .addClaims(map)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(jwtProperties.getAlgorithm(), jwtProperties.getSalt())
                .compact();
    }

    /**
     * 从 jwt 中解析认证的主体.
     * 解析的对象类型由 principleClass 决定。
     */
    private UserDetails getPrinciple(String token) {
        Jws<Claims> jws = Jwts
                .parser()
                .setSigningKey(jwtProperties.getSalt())
                .parseClaimsJws(token);
        DefaultClaims claims = (DefaultClaims) jws.getBody();

        if (claims.containsKey(jwtUserKey)) {
            Object o = objectMapper.convertValue(claims.get(jwtUserKey), parser.principleClass());
            return parser.transferToUserDetails(o);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
