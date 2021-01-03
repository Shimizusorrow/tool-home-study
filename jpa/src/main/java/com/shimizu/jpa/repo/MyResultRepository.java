package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.concurrent.MyCondition;
import com.shimizu.jpa.domain.concurrent.MyResult;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-03 11:03
 */
public interface MyResultRepository extends JpaRepository<MyResult, String> {
    MyResult findByName(String name);
}
