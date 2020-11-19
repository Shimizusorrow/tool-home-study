package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.Equip;
import com.shimizu.jpa.domain.box.EquipBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipRepo extends JpaRepository<Equip, String> {
}
