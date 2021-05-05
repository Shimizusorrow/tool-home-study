package threadpool;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author Shimizu
 * @description
 * @date 2021-05-05 14:27
 */
public class AsyncThreadPool {
    public static Logger log = LoggerFactory.getLogger(AsyncThreadPool.class);
    /**
     * 默认最大并发数<br>
     */
    private static final int DEFAULT_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;

    /**
     * 线程池名称格式
     */
    private static final String THREAD_POOL_NAME = "AsyncThreadPool-";

    /**
     * 线程工厂名称
     */
    private static final ThreadFactory FACTORY = new ThreadFactoryBuilder().setNamePrefix(THREAD_POOL_NAME).build();
    /**
     * 默认队列大小
     */
    private static final int DEFAULT_SIZE = 500;

    /**
     * 默认线程存活时间
     */
    private static final long DEFAULT_KEEP_ALIVE = 60L;

    /**
     * 执行队列
     */
    private static BlockingQueue<Runnable> executeQueue = new LinkedBlockingQueue<>(DEFAULT_SIZE);

    /**
     * NewEntryServiceImpl.java:689
     * Executor
     */
    private static ExecutorService executor;

    static {
        try {
            executor = new ThreadPoolExecutor(DEFAULT_POOL_SIZE,
                    DEFAULT_POOL_SIZE * 2 + 1,
                    DEFAULT_KEEP_ALIVE,
                    TimeUnit.SECONDS,
                    executeQueue,
                    FACTORY);

            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    log.info("AsyncProcessor shutting down.");
                    executor.shutdown();
                    try {
                        if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                            log.error("AsyncProcessor shutdown immediately due to wait timeout.");
                            executor.shutdown();
                        }
                    } catch (InterruptedException e) {
                        log.error("AsyncProcessor shutdown interrupted.");
                        executor.shutdown();
                    }
                    log.info("AsyncProcessor shutting down complete.");
                }
            }));
        } catch (Exception e) {
            log.error("AsyncProcessor init error.", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 此类型无法实例化
     */
    private AsyncThreadPool() {

    }

    /**
     * 获得线程池
     *
     * @return
     */
    public static ExecutorService getExecutor() {
        return executor;
    }

    /**
     * 执行任务，不管是否成功<br>
     * 其实也就是包装以后的 {@link Executer} 方法
     *
     * @param task
     * @return
     */
    public static boolean executeTask(Runnable task) {
        try {
            executor.execute(task);
        } catch (RejectedExecutionException e) {
            log.error("Task executing was rejected.", e);
            return false;
        }
        return true;
    }

    /**
     * 提交任务，并可以在稍后获取其执行情况<br>
     * 当提交失败时，会抛出 {@link }
     *
     * @param task
     * @return
     */
    public static <T> Future<T> submitTask(Callable<T> task) {
        try {
            return executor.submit(task);
        } catch (RejectedExecutionException e) {
            log.error("Task executing was rejected.", e);
            throw new UnsupportedOperationException("Unable to submit the task, rejected.", e);
        }
    }

}
