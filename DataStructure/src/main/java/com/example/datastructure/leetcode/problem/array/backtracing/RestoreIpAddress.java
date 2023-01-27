package com.example.datastructure.leetcode.problem.array.backtracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class RestoreIpAddress {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    public static List<String> restoreIpAddresses(String s) {
        ArrayList<String> validIpList = new ArrayList<>();
        helper(validIpList, s, new LinkedList<>(), 0);
        return validIpList;
    }

    static void helper(List<String> result, String ip, LinkedList<String> ipPart, int i) {
        if (ipPart.size() == 4) {
            String part = String.join(".", ipPart);
            if (ip.length() == i && validateIp(part))
                result.add(part);
            return;
        }
        for (int j = i; j < ip.length(); j++) {
            String ss = ip.substring(i, j + 1);
            if (checkPartIsValid(ss)) {
                ipPart.addLast(ss);
                helper(result, ip, ipPart, j + 1);
                ipPart.removeLast();
            }
        }
    }

    public static boolean validateIp(String ip) {
        String[] split = ip.split("\\.");
        if (split.length != 4)
            return false;
        for (String s : split) {
            if (s.charAt(0) == '0' && s.length() > 1)
                return false;
            int part = Integer.parseInt(s);
            if (part < 0 || part > 255)
                return false;
        }
        return true;
    }

    static boolean checkPartIsValid(String ip) {
        if (ip.length() <= 0 || ip.length() > 4)
            return false;
        if (ip.charAt(0) == '0' && ip.length() > 1)
            return false;
        int part = Integer.parseInt(ip);
        return part >= 0 && part <= 255;
    }

//    25525511135

}
