package com.shimizu.jpa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-19 15:54
 */
@Api("检测打印异常日志")
@RestController
@RequestMapping("/error")
@Slf4j
public class ErrorException {
    @GetMapping("/error")
    @ApiOperation("打印error日志")
    public void error() {
        log.error("I am error");
    }

    @GetMapping("/info")
    @ApiOperation("打印info日志")
    public void info() {
        log.info("I am info");
    }

    @GetMapping("/warn")
    @ApiOperation("打印warn日志")
    public void warn() {
        log.warn("I am warn");
    }
}
