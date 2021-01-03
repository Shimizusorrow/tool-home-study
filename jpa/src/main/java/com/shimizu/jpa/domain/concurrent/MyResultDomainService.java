package com.shimizu.jpa.domain.concurrent;

import com.shimizu.jpa.repo.MyConditionRepository;
import com.shimizu.jpa.repo.MyResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-03 11:14
 */
@Service
@AllArgsConstructor
public class MyResultDomainService {
    private final MyConditionRepository myConditionRepository;
    private final MyResultRepository myResultRepository;
    private final static ConcurrentHashMap<String, MyCondition> map = new ConcurrentHashMap<>();

    public void testConcurrentTest(String name) {
        MyCondition condition = myConditionRepository.findByName(name);
        MyCondition lock = getCondition(condition);
        synchronized (lock) {
            MyResult myResult = myResultRepository.findByName(lock.getName());
            if (Objects.isNull(myResult)) {
                myResult = myResultRepository.save(new MyResult(lock.getName(), 0));
            }
            myResult.addCount();
            myResultRepository.save(myResult);
        }

    }

    private MyCondition getCondition(MyCondition condition) {
        String key = condition.getName() + condition.getModel();
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            map.put(key, condition);
            return condition;
        }
    }
}
