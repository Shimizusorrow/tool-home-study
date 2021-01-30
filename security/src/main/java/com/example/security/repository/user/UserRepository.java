package com.example.security.repository.user;

import com.example.security.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
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

    /**
     * 判断是否存在用户
     *
     * @param username
     * @return
     */
    boolean existsByUsername(String username);

    /**
     * 通过 权限查询
     *
     * @param role
     * @return
     */
    @Query(nativeQuery = true,
            value = "select * from user u where u.role = :role " +
                    "and u.life_cycle = 'RUNNING' ")
    List<User> findByRole(String role);

    /**
     * 查询某权限是否存在用户
     *
     * @param role
     * @return
     */
    boolean existsByRole(User.Role role);
}
