package com.example.security.repository.user;

import com.example.security.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-29 11:41
 */
public interface UserRepository extends JpaRepository<User, String> {
    /**
     * 通过用户名查询
     *
     * @param username
     * @return
     */
    Optional<User> findByUsername(String username);
}
