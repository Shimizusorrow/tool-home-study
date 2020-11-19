package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 学生Crud
 *
 * @author shimizu
 * @date 2020年11月17日11:50:03
 */
public interface StuRepo extends JpaRepository<Student, String> {

    Student findByName(String name);
}
