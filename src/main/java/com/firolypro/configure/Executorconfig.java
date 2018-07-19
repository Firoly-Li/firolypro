package com.firolypro.configure;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

/**
 * com.firolypro.configure
 * lihaoyang
 * 2018/6/25
 * 下午6:08
 **/


/**
 *
 * 功能描述: 配置线程池
 *
 * @param:
 * @return:
 * @auther:
 * @date:
 */
@Configuration
@EnableAsync
public class Executorconfig {
//    private static final Logger logger;
//
//    static {
//        logger = (Logger) LoggerFactory.getLogger(Executorconfig.class);
//    }


    @Bean
    public Executor asyncServiceExecutor() {
        System.out.println("asyncServiceExecutor 开始");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(5);

        executor.setMaxPoolSize(5);

        executor.setQueueCapacity(999999);

        executor.setThreadNamePrefix("async-service-");

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        executor.initialize();
        return executor;
    }


}
