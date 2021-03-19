package com.shimizu.jpa.controller;

import com.shimizu.jpa.config.TimerProperties;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

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
    private final TimerProperties timerProperties;

    @GetMapping("/mulipart")
    @ApiOperation("MultipartProperties")
    public MultipartProperties getProperties() {
        return properties;
    }

    @GetMapping("/tool")
    @ApiOperation("/TimerProperties")
    public TimerProperties properties() {
        return timerProperties;
    }

    @PutMapping("/tool-update")
    @ApiOperation("更改配置类")
    public TimerProperties propertiesUp(@RequestParam long data) {
        timerProperties.setF1Time(Duration.ofDays(data));
        return timerProperties;
    }
}
