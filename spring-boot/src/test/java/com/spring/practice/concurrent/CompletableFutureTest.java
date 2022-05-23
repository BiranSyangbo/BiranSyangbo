package com.spring.practice.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {

    boolean isRequestForStop = false;

    private String sleepAndReturnString() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "12";
    }

    @Test
    public void test_completableFuture1() throws ExecutionException, InterruptedException {
        System.out.println("Process running");

        CompletableFuture.supplyAsync(this::sleepAndReturnString)
                .thenApply(Integer::parseInt)
                .thenApply(n -> n * 2)
//                .cancel(false);
                .get();
//        System.out.println(cancel);

        System.out.println("Process running");
    }

    @Test
    public void test_CompletableFuture2() {
        int a = 10;
        int b = 20;
        CompletableFuture.supplyAsync(this::sleepAndReturnString)
                .thenApply(Integer::parseInt)
                .thenApply(n -> n * a)
                .thenCombine(CompletableFuture.supplyAsync(() -> b), (n1, n2) -> "Result is " + (Integer.sum(n1, n2)))
                .thenAccept(System.out::println)
                .join();

    }

    @Test
    public void test_thread() throws InterruptedException {


    }
}
