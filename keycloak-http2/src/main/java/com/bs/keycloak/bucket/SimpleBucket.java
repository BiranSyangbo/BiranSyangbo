package com.bs.keycloak.bucket;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class SimpleBucket {

    Bucket bucket;

    public SimpleBucket() {
        Bandwidth bandwidth = Bandwidth.simple(5, Duration.ofSeconds(5));
        bucket = Bucket.builder()
                .addLimit(bandwidth)
                .build();
    }

    @GetMapping("/rate/limit")
    public ResponseEntity<String> rateLimit() {
        ConsumptionProbe prob = bucket.tryConsumeAndReturnRemaining(1);
        if (prob.isConsumed()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .header("X-Rate-Limit-Remaining", Long.toString(prob.getRemainingTokens()))
                    .body("Request Accepted:- " + prob.getRemainingTokens());
        }
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .header("X-Rate-Limit-Retry-After-Seconds", String.valueOf(prob.getNanosToWaitForRefill() / 1_000_000_000))
                .body("Too Many Request");
    }
}
