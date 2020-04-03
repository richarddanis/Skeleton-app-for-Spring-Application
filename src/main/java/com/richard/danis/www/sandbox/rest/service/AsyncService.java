package com.richard.danis.www.sandbox.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    private final Logger LOGGER = LoggerFactory.getLogger(AsyncService.class);

    @Async("asyncExecutor")
    public CompletableFuture<String> methodOne() throws InterruptedException {
        LOGGER.info("Execution started in methodOne");
        Thread.sleep(1000);
        LOGGER.info("Execution finished in methodOne");
        return CompletableFuture.completedFuture("methodOne");
    }

    @Async("asyncExecutor")
    public CompletableFuture<String> methodTwo() throws InterruptedException {
        LOGGER.info("Execution started in methodTwo");
        Thread.sleep(5000);
        LOGGER.info("Execution finished in methodTwo");
        return CompletableFuture.completedFuture("methodTwo");
    }

    @Async("asyncExecutor")
    public CompletableFuture<String> methodThree() throws InterruptedException {
        LOGGER.info("Execution started in methodThree");
        Thread.sleep(2500);
        LOGGER.info("Execution finished in methodThree");
        return CompletableFuture.completedFuture("methodThree");
    }
}
