package com.sky.lli.config.thread;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.MINUTES;

/**
 * 类名：ThreadPoolExecutorFactory
 * 描述：自定义线程池工厂
 *
 * @author klaus
 * @date 2020-01-01
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ThreadPoolExecutorFactory {
    /**
     * CORE_POOL_SIZE 池中所保存的线程数，包括空闲线程。
     */
    private static final int CORE_POOL_SIZE = 100;
    /**
     * MAXIMUM_POOL_SIZE - 池中允许的最大线程数(采用LinkedBlockingQueue时没有作用)。
     */
    private static final int MAXIMUM_POOL_SIZE = 150;
    /**
     * KEEP_ALIVE_TIME -当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间，线程池维护线程所允许的空闲时间
     */
    private static final int KEEP_ALIVE_TIME = 60;
    /**
     * 线程池对象
     */
    private static ThreadPoolExecutor threadPoolExecutor = null;

    /**
     * Spring异步线程池对象
     */
    private static ThreadPoolTaskExecutor springAsyncThreadPoolExecutor = null;
    /**
     * CORE_POOL_SIZE 池中所保存的线程数，包括空闲线程。
     */
    private static final int SPRING_ASYNC_CORE_POOL_SIZE = 100;
    /**
     * Spring 异步线程池大小
     */
    private static final int SPRING_ASYNC_MAXIMUM_POOL_SIZE = 150;
    /**
     * spring 异步线程执行名称前缀
     */
    public static final String USER_SPRING_ASYNC_EXECUTOR = "My-Spring-Async-Executor";

    /**
     * 获取执行线程
     *
     * @return 返回线程执行
     */
    public static ThreadPoolExecutor getThreadPoolExecutor() {
        if (null == threadPoolExecutor) {
            ThreadPoolExecutor t;
            synchronized (ThreadPoolExecutor.class) {
                t = threadPoolExecutor;
                if (null == t) {
                    synchronized (ThreadPoolExecutor.class) {
                        t = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, MINUTES, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.DiscardOldestPolicy());
                    }
                    threadPoolExecutor = t;
                }
            }
        }
        return threadPoolExecutor;
    }

    /**
     * 获取执行线程
     *
     * @return 返回线程执行
     */
    public static ThreadPoolTaskExecutor getSpringAsyncThreadPoolExecutor() {
        if (null == springAsyncThreadPoolExecutor) {
            ThreadPoolTaskExecutor t;
            synchronized (ThreadPoolTaskExecutor.class) {
                t = springAsyncThreadPoolExecutor;
                if (null == t) {
                    synchronized (ThreadPoolTaskExecutor.class) {
                        t = new ThreadPoolTaskExecutor();
                        t.initialize();
                        t.setCorePoolSize(SPRING_ASYNC_CORE_POOL_SIZE);
                        t.setQueueCapacity(Integer.MAX_VALUE);
                        t.setThreadNamePrefix(USER_SPRING_ASYNC_EXECUTOR);
                        t.setMaxPoolSize(SPRING_ASYNC_MAXIMUM_POOL_SIZE);
                        t.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
                        t.setWaitForTasksToCompleteOnShutdown(true);
                        t.setAwaitTerminationSeconds(60);
                    }
                    springAsyncThreadPoolExecutor = t;
                }
            }
        }
        return springAsyncThreadPoolExecutor;
    }
}