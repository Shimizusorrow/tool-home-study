package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.box.EquipItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EquipItemRepo extends JpaRepository<EquipItem, String> {
    /**
     * 将装备和箱进行解绑
     *
     * @param equipId
     */
    @Query(nativeQuery = true,
            value = "delete from equip_item ei where ei.equip_id = :equipId")
    @Modifying
    void remapEquip(String equipId);
}
