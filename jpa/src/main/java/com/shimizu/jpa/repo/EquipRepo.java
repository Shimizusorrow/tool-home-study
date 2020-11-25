package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.Equip;
import com.shimizu.jpa.domain.box.EquipBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipRepo extends JpaRepository<Equip, String> {

    /**
     * 测试原生Sql 查询state
     *
     * @param state
     * @return
     */
    @Query(nativeQuery = true,
            value = "select * from equip e " +
                    "where e.state = :state")
    List<Equip> findByState(boolean state);
}
