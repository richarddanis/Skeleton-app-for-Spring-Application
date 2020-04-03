package com.richard.danis.www.sandbox.rest.controller;

import com.richard.danis.www.sandbox.rest.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.CompletableFuture;

/**
 * Controller for async calls.
 */
@Controller
public class RestAsyncController {

    private final Logger LOGGER = LoggerFactory.getLogger(RestAsyncController.class);

    private AsyncService asyncService;

    public RestAsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/message")
    public ResponseEntity<String> asyncMessage() {
        try {
            LOGGER.info("Async message called.");
            long start = System.currentTimeMillis();

            CompletableFuture<String> methodOne = asyncService.methodOne();
            CompletableFuture<String> methodTwo = asyncService.methodTwo();
            CompletableFuture<String> methodThree = asyncService.methodThree();

            long end = System.currentTimeMillis();
            CompletableFuture.allOf().join();

            LOGGER.info("Finished execution.");
            String methodOneResult = methodOne.get();
            String methodTwoResult = methodTwo.get();
            String methodThreeResult = methodThree.get();

            return new ResponseEntity<>(String.format("%s - %s - %s", methodOneResult, methodTwoResult, methodThreeResult), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Something went wrong in execution: {}", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
