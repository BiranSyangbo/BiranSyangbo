package com.spring.practice.concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    private static boolean isRequestForStop = false;

    private static void requestStop() {
        isRequestForStop = true;
    }

    private static boolean stopRequested() {
        return isRequestForStop;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!isRequestForStop) {
                System.out.println("Times Called  ==> " + i);
                i++;
            }
        });
        thread.start();

        TimeUnit.MILLISECONDS.sleep(100);
        isRequestForStop = true;
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println(thread.isAlive());
    }
}
