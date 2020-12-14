package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.complex.Chair;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shimizu
 * @description
 * @date 2020-12-10 15:12
 */
public interface ChairRepository extends JpaRepository<Chair,String> {
}
