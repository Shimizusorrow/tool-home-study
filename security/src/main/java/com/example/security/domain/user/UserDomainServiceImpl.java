package com.example.security.domain.user;

import com.example.security.repository.UserRepository;
import com.example.security.util.PasswordEncoderUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-29 11:41
 */
@Service("UserDomainServiceImpl")
@AllArgsConstructor
public class UserDomainServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(() -> new RuntimeException("用户不存在"));
    }

    public void initSuperAdmin() {
        if (!userRepository.existsByRole(User.Role.SUPER_ADMIN)) {
            String superAdmin = "超级管理员";
            String superAdminUsername = "1";
            String superAdminPassword = "1";
            save(new User(superAdminUsername, superAdminPassword,
                    User.Role.SUPER_ADMIN, superAdmin));
        }
    }

    public User save(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("账号已存在");
        }
        user.setPassword(PasswordEncoderUtils
                .getBCryptPasswordEncoder()
                .encode(user.getPassword()));
        return userRepository.save(user);
    }
}
