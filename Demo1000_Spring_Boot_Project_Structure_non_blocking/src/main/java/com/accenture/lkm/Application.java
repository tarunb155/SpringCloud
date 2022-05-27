package com.accenture.lkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean("threadPoolTaskExecutorMSD")
    public TaskExecutor getThreadPoolExecutorMSD(){
    	ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    	executor.setCorePoolSize(20);
    	executor.setMaxPoolSize(1000);
    	executor.setWaitForTasksToCompleteOnShutdown(true);
    	executor.setThreadNamePrefix("MSDThread-");
    	return executor;
    }
}

//@SpringBootApplication
// @configuration
// @componentscan
// @Enableautoconfiguration
//https://dzone.com/articles/spring-boot-creating-asynchronous-methods-using-as