package com.example.datastructure.random;

import java.util.Random;

public class GenerateRandom {

    public static int random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
