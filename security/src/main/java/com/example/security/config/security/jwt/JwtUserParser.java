package com.example.security.config.security.jwt;

import com.example.security.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * Created Date : 2020/10/14
 *
 * @author zzk
 */
@Component
@AllArgsConstructor
public class JwtUserParser implements JwtSecurityUserParser {

    @Qualifier("UserDomainServiceImpl")
    private final UserDetailsService userDetailsService;

    @Override
    public UserDetails transferToUserDetails(Object securityUser) {
        JwtUser principle = (JwtUser) securityUser;
        return userDetailsService.loadUserByUsername(principle.username);
    }

    @Override
    public Class<?> principleClass() {
        return JwtUser.class;
    }

    @Override
    public Object transferToSecurityUser(UserDetails userDetails) {
        User user = (User) userDetails;
        return new JwtUser()
                .setId(user.getId())
                .setName(user.getName())
                .setUsername(user.getUsername())
                .setRole(user.getRole());

    }

    /**
     * 用于将用户的敏感信息擦除
     */
    @Data
    @Accessors(chain = true)
    public static class JwtUser {
        private String id;

        private String name;

        private String username;

        private User.Role role;

    }

}