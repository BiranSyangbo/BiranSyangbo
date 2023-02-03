package com.bs.keycloak.ratelimit;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import io.github.bucket4j.local.LocalBucket;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Bucket4j {


    public static void main(String[] args) throws InterruptedException {
//        test();
    }

    @Test
    void test() {
        Bandwidth limit = Bandwidth.classic(1, Refill.intervally(1, Duration.ofSeconds(2)));
        Bucket bucket = Bucket.builder()
                .addLimit(limit)
                .build();
        assertTrue(bucket.tryConsume(1));     // first request
        Executors.newScheduledThreadPool(1)   // schedule another request after 2 seconds later
                .schedule(() -> assertTrue(bucket.tryConsume(1)), 2, TimeUnit.SECONDS);
    }

    @Test
    void testCase1() throws InterruptedException {
        Refill refill = Refill.greedy(10, Duration.ofSeconds(1));
        Bandwidth limit = Bandwidth.classic(30, refill);
        Bucket bucket = Bucket.builder()
                .addLimit(limit)
                .build();
        for (int i = 1; i < 50; i++) {
            System.out.println(bucket.tryConsumeAndReturnRemaining(1));
            Thread.sleep(200);
        }
    }

    @Test
    void simpleBandWithExample() throws InterruptedException {
        Bandwidth bandwidth = Bandwidth.simple(50, Duration.ofSeconds(1));
        Bucket bucket = Bucket.builder().addLimit(bandwidth).build();
        int i = 0;
        while (i < 50) {
            assertTrue(bucket.tryConsume(1));
            i++;
        }
        assertFalse(bucket.tryConsume(1));
    }
}
