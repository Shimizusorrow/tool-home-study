package com.example.security.controller;

import com.example.security.domain.user.User;
import com.example.security.domain.user.UserDomainServiceImpl;
import com.example.security.repository.user.UserRepository;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-29 14:29
 */
@ApiModel(value = "用户层")
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserDomainServiceImpl userDomainServiceImpl;
    private final UserRepository userRepository;

    @ApiOperation("新增 用户")
    @PostMapping("/add.user")
    public User add(@RequestBody User user) {
        return userDomainServiceImpl.save(user);
    }

    @ApiOperation("查询用户列表")
    @GetMapping("/get.list")
    public List<User> list() {
        return userRepository.findAll();
    }

}
