package com.example.datastructure.msc;

public class Sample4 {
    public static void main(String[] args) {
        System.out.println(f(-5001000));
    }

    static int f(int n) {
        int sign = 1;
        if (n < 0) {
            n = n * -1;
            sign = -1;
        }
        int reverse = 0;
        while (n > 0) {
            reverse = (reverse * 10) + (n % 10);
            n = n / 10;
        }
        return reverse * sign;
    }
}
