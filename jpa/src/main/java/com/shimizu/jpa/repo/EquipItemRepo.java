package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.box.EquipItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipItemRepo extends JpaRepository<EquipItem, String> {
}
