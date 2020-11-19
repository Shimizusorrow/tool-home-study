package com.shimizu.jpa.service;

import com.shimizu.jpa.domain.Equip;
import com.shimizu.jpa.event.EquipEvent;
import com.shimizu.jpa.repo.EquipItemRepo;
import com.shimizu.jpa.repo.EquipRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@AllArgsConstructor
@Slf4j
public class EquipServie {
    private final EquipRepo equipRepo;
    private final EquipItemRepo equipItemRepo;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void after(EquipEvent equipEvent) {
        Equip equip = equipEvent.getEquip();
        log.info("-------------------------------after");
        if (equip.isState()) {
            equipItemRepo.remapEquip(equip.getId());
        }
    }
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void before(EquipEvent equipEvent) {
        Equip equip = equipEvent.getEquip();
        log.info("-------------------------------before");
        if (equip.isState()) {
            equipItemRepo.remapEquip(equip.getId());
        }
    }

    @EventListener
    public void remapEquips(Equip equip) {
        log.info("解除成功！");
        if (equip.isState()) {
            equipItemRepo.remapEquip(equip.getId());
        }
    }
}
