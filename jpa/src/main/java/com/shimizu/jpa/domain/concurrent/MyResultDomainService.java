package com.shimizu.jpa.domain.concurrent;

import com.shimizu.jpa.repo.MyConditionRepository;
import com.shimizu.jpa.repo.MyResultRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-03 11:14
 */
@Service
@AllArgsConstructor
@Slf4j
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

    @Transactional(rollbackFor = Exception.class)
    public void deleteAndInsert(List<String> names) {
        try {
            myResultRepository.deleteAllByNames(names);
            List<MyResult> collect = names.stream()
                    .map(it -> new MyResult(it, 0))
                    .collect(Collectors.toList());
            myResultRepository.saveAll(collect);
            log.info("执行了save"+names.toString());
        } catch (CannotAcquireLockException e) {
            e.printStackTrace();
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
