package com.shimizu.jpa.controller;

import com.shimizu.jpa.domain.concurrent.MyResultDomainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-03 10:57
 */
@Api(tags = "并发测试")
@RestController
@RequestMapping("/concurrent")
@AllArgsConstructor
public class ConcurrentTestingController {
    private final MyResultDomainService myResultDomainService;

    @ApiOperation("并发测试 增加数据")
    @GetMapping
    public void test(@RequestParam String name) {
        myResultDomainService.testConcurrentTest(name);
    }

    @ApiOperation("测试并发 删除新增")
    @GetMapping("test")
    public void del_inser(@RequestParam List<String> names) {
        myResultDomainService.deleteAndInsert(names);
    }
}
