package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.complex.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shimizu
 * @description
 * @date 2020-12-10 15:13
 */
public interface ClassRoomRepository extends JpaRepository<ClassRoom, String> {
}
