package com.shimizu.jpa.controller;

import com.shimizu.jpa.annotion.LogAnnotation;
import com.shimizu.jpa.annotion.SuperAnnotation;
import com.shimizu.jpa.domain.Equip;
import com.shimizu.jpa.domain.Teacher;
import com.shimizu.jpa.repo.EquipRepo;
import com.shimizu.jpa.repo.TeaRepo;
import com.shimizu.jpa.service.EquipServie;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.management.timer.Timer;


@RequestMapping("/equip")
@AllArgsConstructor
@RestController
@Slf4j
public class EquipController {
    private EquipServie equipServie;
    private EquipRepo equipRepo;
    private TeaRepo teaRepo;

    @PutMapping("/test")
    public void changeEquipState(@RequestParam String equipId,
                                 @RequestParam boolean state) throws Exception {
        Equip equip = equipRepo.findById(equipId).orElseThrow(() -> new Exception("装备不存在"));
        equip.setState(state);
        equipRepo.save(equip);
        log.info("修改成功======");
    }

    @GetMapping("/test2")
    public Teacher find() {
        return teaRepo.findByName("王1");
    }

    @SneakyThrows
    @GetMapping("/test3")
    @LogAnnotation("test333")
    public void test3() {
        log.info("开始睡眠");
        Thread.sleep(Timer.ONE_SECOND * 5);
        log.info("结束睡眠");
    }

}
