package com.shimizu.jpa.domain;

import com.shimizu.jpa.repo.ElementDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-09 10:33
 */
@Service
@AllArgsConstructor
public class ElementDomainService {
    private final ElementDomainRepository elementDomainRepository;

}
