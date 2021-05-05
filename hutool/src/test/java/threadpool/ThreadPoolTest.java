package threadpool;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Shimizu
 * @description
 * @date 2021-05-05 11:42
 */
@ExtendWith(SpringExtension.class)
public class ThreadPoolTest {
    @Test
    void t1() {
        int cpuCore = Runtime.getRuntime().availableProcessors();
        final int poolSize = (int) (cpuCore / (1 - 0.9));
        System.out.println("poolSize:" + poolSize);
        System.out.println("cpuCore:" + cpuCore);
    }

    @Test
    void t2() {
        for (int i = 0; i < 10; i++) {
            AsyncThreadPool.executeTask(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "睡眠完毕");
            });
        }
        ExecutorService executor = AsyncThreadPool.getExecutor();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        AsyncThreadPool.waitMain(1000);

//        AsyncThreadPool.waitTask();
    }
}
