package com.shimizu.jpa.controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-15 11:10
 */
@RestController
@RequestMapping("/properties")
@AllArgsConstructor
public class PropertiesController {
    private final MultipartProperties properties;

    @GetMapping("/mulipart")
    @ApiOperation("MultipartProperties")
    public MultipartProperties getProperties() {
        return properties;
    }
}
