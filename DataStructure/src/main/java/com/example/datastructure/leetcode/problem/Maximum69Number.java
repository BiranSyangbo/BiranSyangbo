package com.example.datastructure.leetcode.problem;

public class Maximum69Number {
    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
    }

    public static int maximum69Number(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
          if(chars[i] == '6'){
              chars[i] = '9';
              break;
          }

        }
        return Integer.parseInt(String.valueOf(chars));
    }
    // My Solution
//    public static int maximum69Number(int num) {
//        String val = String.valueOf(num);
//        int ans = num;
//        for (int i = 0; i < val.length(); i++) {
//            StringBuilder builder = new StringBuilder(String.valueOf(num));
//            if ((builder.charAt(i) - '0') % 6 == 0)
//                builder.setCharAt(i, '9');
//            else if ((builder.charAt(i) - '0') % 9 == 0)
//                builder.setCharAt(i, '6');
//            ans = Math.max(ans, Integer.parseInt(builder.toString()));
//        }
//        return ans;
//    }
}
