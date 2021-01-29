package com.example.security.domain.user;

import com.example.security.domain.base.BaseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Collection;

/**
 * @author Shimizu
 * @description 用户
 * @date 2021-01-29 10:51
 */
@Entity
@NoArgsConstructor
@Setter
@Getter
@Api(tags = "用户")
public class User extends BaseEntity implements UserDetails {
    @ApiModelProperty(value = "账号")
    @NonNull
    private String username;

    @ApiModelProperty("密码")
    @NonNull
    private String password;

    @ApiModelProperty("权限")
    @Enumerated(EnumType.STRING)
    @NonNull
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    enum Role {
        /**
         * 权限
         */
        ADMIN("管理员"),
        SUPER_ADMIN("超级管理员"),
        NORMAL_USER("普通用户");
        /**
         * 中文解释
         */
        private final String chinese;

        Role(String chinese) {
            this.chinese = chinese;
        }
    }
}
