package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shimizu
 * @date 2020年11月17日13:23:00
 */
public interface TeaRepo extends JpaRepository<Teacher, String> {
    /**
     * 通过名称查询
     *
     * @param name
     * @return
     */
    Teacher findByName(String name);
}
