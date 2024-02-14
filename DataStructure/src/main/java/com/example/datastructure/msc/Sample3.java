package com.example.datastructure.msc;

import java.util.Arrays;

public class Sample3 {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        char[] f = f(chars, 1, 1);
        System.out.println(Arrays.toString(f));
    }

    static char[] f(char[] a, int start, int len) {
        if (a == null || len < 0 || start < 0 || (start + len) > a.length)
            return null;
        char[] result = new char[len];
        for (int i = start, j = 0; j < len; i++, j++) {
            result[j] = a[i];
        }
        return result;
    }

    static char[] a3(char[] a, int start, int length)
    {
        if (length < 0 || start < 0 || start+length-1>=a.length)
        {
            return null;
        }

        char[] sub = new char[length];
        for (int i=start, j=0; j<length; i++, j++)
        {
            sub[j] = a[i];
        }

        return sub;
    }
}
