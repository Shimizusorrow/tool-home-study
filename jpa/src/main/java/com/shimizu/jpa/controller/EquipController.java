package com.shimizu.jpa.controller;

import com.shimizu.jpa.domain.Equip;
import com.shimizu.jpa.domain.Teacher;
import com.shimizu.jpa.repo.EquipRepo;
import com.shimizu.jpa.repo.TeaRepo;
import com.shimizu.jpa.service.EquipServie;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public Teacher find(){
        return teaRepo.findByName("王1");
    }

}
