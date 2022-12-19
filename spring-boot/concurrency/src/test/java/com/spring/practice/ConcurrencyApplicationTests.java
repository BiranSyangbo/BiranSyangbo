package com.spring.practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
class ConcurrencyApplicationTests {

    @Test
    void contextLoads() {
        this.getClass().getClassLoader().getResource("");
    }

}
