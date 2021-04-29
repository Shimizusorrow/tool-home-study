package com.shimizu.tools.tool.http;

import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.shimizu.tools.tool.util.JsonUtils;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-29 09:06
 */
@ExtendWith(SpringExtension.class)
public class HttpTools {
    @Test
    void get() {
        String url = "http://192.168.1.137:8010/warehouse/images/0bd7a4aa9b324e91b0d22be4a065acb2.jpg";
        try {
            System.out.println(HttpUtil.createGet(url).execute().getStatus());

        } catch (Exception e) {
            System.out.println("图片不存在");
        }
    }

    private int getState(String image) {
        String url = "http://192.168.1.137:8010/warehouse/images/" + image;
        return HttpUtil.createGet(url).execute().getStatus();
    }

    @Test
    void getEquipArg() {
        String url = "http://192.168.1.137:8010/warehouse/upload-plat/equip-arg";
        String rs = HttpUtil.get(url);
        JsonNode tree = JsonUtils.readTree(rs);
        List<TempData> tempDatas = new ArrayList<>();
        for (int i = 0, len = tree.size(); i < len; i++) {
            JsonNode equipArg = tree.get(i);
            String id = equipArg.get("id").asText();
            String image = equipArg.get("image").asText();
            if (image != null) {
                tempDatas.add(new TempData(id, image));
            }
        }
        List<String> rsIds = new ArrayList<>();
        tempDatas.forEach(it -> {
            int state = getState(it.getImage());
            if (state == 404) {
                rsIds.add(it.getId());
            }
        });
        rsIds.forEach(System.out::println);

    }

    @Data
    private class TempData {
        private String id;
        private String image;

        public TempData(String id, String image) {
            this.id = id;
            this.image = image;
        }
    }
}
