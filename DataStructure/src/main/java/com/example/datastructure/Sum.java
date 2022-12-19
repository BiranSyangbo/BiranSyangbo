package com.example.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Sum {

    public static void main(String[] args) {

        long l = System.nanoTime();
        System.out.println(sumValue(100000));
        long l1 = System.nanoTime();
        System.out.println(sum(100000));
        long l2 = System.nanoTime();
        System.out.println("First One " + (l1 - l));
        System.out.println("Second One " + (l2 - l1));
        List<String> a = new ArrayList<>();
        a.add("ABC");
        a.add("B");
        a.remove("B");
        a.add("C");


    }
    public static double sum(double n){
        return n * (n +1)/2;
    }

    public static double sumValue(double n){
        double d = 0;
        for (int i = 0; i <= n; i++) {
            d += i;
        }
        return d;
    }
}
