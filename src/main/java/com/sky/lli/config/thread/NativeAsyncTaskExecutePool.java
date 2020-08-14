package com.sky.lli.config.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 描述：原生(Spring)异步任务线程池装配类
 *
 * @author klaus
 * @date 2019-08-14
 */

@Slf4j
@EnableAsync
@Configuration
public class NativeAsyncTaskExecutePool implements AsyncConfigurer {

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
     * spring 异步线程执行名称前缀
     */
    private static final String USER_SPRING_ASYNC_EXECUTOR = "LLI-Spring-Async-Executor";

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.initialize();
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAXIMUM_POOL_SIZE);
        executor.setQueueCapacity(Integer.MAX_VALUE);
        executor.setKeepAliveSeconds(KEEP_ALIVE_TIME);
        executor.setThreadNamePrefix(USER_SPRING_ASYNC_EXECUTOR);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        return executor;
    }

    /**
     * 异步任务中异常处理
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (arg0, arg1, arg2) -> {
            log.error("=========================={}=======================", arg0.getMessage(), arg0);
            log.error("exception method:{}", arg1.getName());
        };
    }
}
