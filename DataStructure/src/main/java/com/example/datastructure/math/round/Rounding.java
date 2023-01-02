package com.example.datastructure.math.round;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class Rounding {

    public static void main(String[] args) {
        MathContext rounding = new MathContext(8, RoundingMode.HALF_EVEN);
        List<Double> doubles = Arrays.asList(197.46, 198.01, 198.56, 199.11, 199.66, 200.21, 200.77, 201.32, 201.88, 203.02);
        BigDecimal sum = BigDecimal.ZERO;
        for (Double aDouble : doubles) {
            BigDecimal bigDecimal = BigDecimal.valueOf(aDouble);
            BigDecimal divide = bigDecimal.multiply(BigDecimal.TEN).divide(new BigDecimal(100), rounding);
            System.out.println(divide);
            sum = sum.add(divide);
        }
        System.out.println(sum);

        BigDecimal ann =new BigDecimal("14.4");
        BigDecimal divide = ann.divide(new BigDecimal(52), rounding);
    }
}
