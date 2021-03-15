package com.example.shimizu.sync;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-10 10:16
 */
@Api(tags = "webTest")
@RestController
@RequestMapping("/web")
@AllArgsConstructor
public class WebController {
    private WebService webService;

    @GetMapping("/test")
    @ApiOperation("测试")
    public Object test(String houseId) throws Exception {
        return webService.send(houseId);
    }
}
