package com.shimizu.hutool.abstracts;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Shimizu
 * @description
 * @date 2021-04-28 10:02
 */
public abstract class AbstractNumberGenerate {
    protected static Set<Object> set = Collections.synchronizedSet(new HashSet<>());

    public static Set<Object> getSet() {
        return set;
    }

    public static void setSet(Set<Object> set) {
        AbstractNumberGenerate.set = set;
    }
}
