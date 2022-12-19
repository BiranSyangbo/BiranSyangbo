package com.example.datastructure.leetcode.problem;

public class StringToInteger8 {
    public static void main(String[] args) {
//        System.out.println("A".charAt(0) - '0');
//        System.out.println(myAtoi(" "));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE / 10);
    }

    public static int myAtoi(String s) {
        if (s.length() == 0)
            return 0;
        int size = s.length();
        int index = 0;
        while (index < size && s.charAt(index) == ' ')
            index++;
        boolean isNegative = false;
        if (index == size)
            return 0;
        if (s.charAt(index) == '-') {
            isNegative = true;
            index++;
        } else if (s.charAt(index) == '+')
            index++;
        int a = 0;
        if (index == size)
            return 0;
        while (index < size && Character.isDigit(s.charAt(index))) {
            int pop = Integer.parseInt(String.valueOf(s.charAt(index)));
            if (a > Integer.MAX_VALUE / 10 || (a == Integer.MAX_VALUE / 10 && pop > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            a = a * 10 + pop;
            index++;

        }
        return isNegative ? a * -1 : a;
    }
}
