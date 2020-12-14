package com.shimizu.jpa.domain.node;

import com.shimizu.jpa.repo.ClassificationNodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Shimizu
 * @description
 * @date 2020-12-14 10:08
 */
@Service
@AllArgsConstructor
public class ClassificationNodeDomainService {
    private final ClassificationNodeRepository classificationNodeRepository;

}
