package com.shimizu.excel.repo;

import com.shimizu.excel.domain.EquipClassification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/21 14:48
 */
public interface EquipClassificationRepo extends JpaRepository<EquipClassification, String> {
}
