package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.concurrent.MyCondition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-03 11:03
 */
public interface MyConditionRepository extends JpaRepository<MyCondition, String> {
    MyCondition findByName(String name);
}
