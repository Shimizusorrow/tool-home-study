package com.example.shimizu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-10 10:53
 */
@RequestMapping("/test")
@RestController
@Api(tags = "test")
public class TestController {
    @GetMapping("/test")
    @ApiOperation("test")
    public Datas get() {
        return new Datas("hello", "world");
    }

    /**
     *
     */
    @Data
    private static class Datas {
        private String a;
        private String bs;
        private String c;

        public Datas(String a, String bs) {
            this.a = a;
            this.bs = bs;
        }
    }
}
