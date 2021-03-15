package com.example.shimizu.sync;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-10 10:21
 */
@Service
@AllArgsConstructor
public class WebService {
    private final WebRestTemplate webRestTemplate;

    public WebRestTemplate.Datas send(String ip) throws Exception {
        return webRestTemplate.xx(ip, 1, Integer.MAX_VALUE);
    }
}
