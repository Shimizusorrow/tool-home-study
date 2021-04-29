package com.shimizu.hutool;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@NoArgsConstructor
public class Box {

    public static String name;
    //    @NotNull
    public static List<String> goods;

    @Value("#{'${box.name}'}")
    public void setName(String name) {
        Box.name = name;
    }

    @Value("${box.list}")
    public void setGoods(List<String> goods) {
        Box.goods = goods;
    }
}