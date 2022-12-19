package com.example.datastructure.leetcode.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParanthesis22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        isStringParenthesisIsValidLeetCode(new StringBuilder(), 0, 0, n, ans);
        System.out.println(ans);
        return ans;
    }

    public static void isStringParenthesisIsValidLeetCode(StringBuilder sb, int left, int right, int n, List<String> res) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            isStringParenthesisIsValidLeetCode(sb, left + 1, right, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            isStringParenthesisIsValidLeetCode(sb, left, right + 1, n, res);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static List<String> isStringParanthesis(String s, List<String> ans, int n) {
        if (s.length() == n * 2) {
            if (isValid(s))
                ans.add(s);
            return ans;
        }
        isStringParanthesis(s.concat("("), ans, n);
        isStringParanthesis(s.concat(")"), ans, n);
        return ans;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push('(');
            if (stack.isEmpty())
                return false;
            if (c == ')')
                stack.pop();
        }
        return stack.isEmpty();
    }


}
