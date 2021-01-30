package com.example.security.config.shell;

import com.example.security.domain.user.UserDomainServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-29 14:33
 */
@Component
@AllArgsConstructor
public class DataInitShell implements CommandLineRunner {
    private final UserDomainServiceImpl userDomainServiceImpl;

    @Override
    public void run(String... args) {
        userDomainServiceImpl.initSuperAdmin();
    }
}
