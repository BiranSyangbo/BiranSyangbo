package com.example.datastructure.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversation {

    public static void main(String[] args) {
        System.out.println(converterAsElevator("PAYPALISHIRING", 4));
        // PINALSIGYAHRPI
    }

    public static String convert(String s, int numRows) {

        if(numRows == 1)
            return s;
        List<StringBuilder> builders = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            builders.add(new StringBuilder());
        }
        int row = 0;
        boolean isDown = false;
        for (char c : s.toCharArray()) {
            builders.get(row).append(c);
            if (row == 0 || row == numRows - 1)
                isDown = !isDown;
            row += isDown ? 1 : -1;
        }
        StringBuilder b = new StringBuilder();
        for (StringBuilder builder : builders) {
            b.append(builder.toString());
        }
        return b.toString();
    }

    public static String converterAsElevator(String s, int numRows) {
        if(numRows == 1)
            return s;
        String ans = "";
        StringBuilder[] builders = new StringBuilder[numRows];
        for(int i=0 ; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }

        int index = 0;
        boolean isGodingDown = false;
        for(char c : s.toCharArray()) {
            builders[index].append(c);
            if(index==0 || index == numRows -1) isGodingDown = !isGodingDown;
            index = isGodingDown ? 1 : -1;
        }

        for(StringBuilder b : builders ) {
            ans += b.toString();
        }

        return ans;
    }
}
