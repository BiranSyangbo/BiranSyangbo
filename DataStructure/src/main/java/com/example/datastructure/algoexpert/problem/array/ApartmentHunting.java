package com.example.datastructure.algoexpert.problem.array;

import java.util.*;

public class ApartmentHunting {

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[][] hunting = new int[reqs.length][blocks.size()];
        for (int i = 0; i < blocks.size(); i++) {
            final Map<String, Boolean> block = blocks.get(i);
            for (int j = 0; j < reqs.length; j++) {
                if (block.get(reqs[j])) {
                    hunting[j][i] = 0;
                } else {
                    int p;
                    if (i - 1 < 0) {
                        p = Integer.MAX_VALUE - 10;
                    } else {
                        if (hunting[j][i - 1] != -1)
                            p = hunting[j][i - 1] + 1;
                        else
                            p = Integer.MAX_VALUE - 10;
                    }
                    hunting[j][i] = p;
                }
            }
        }
        int[] result = new int[blocks.size()];
        for (int i = blocks.size() - 1; i >= 0; i--) {
            final Map<String, Boolean> block = blocks.get(i);
            int val = 0;
            for (int j = 0; j < reqs.length; j++) {
                if (block.get(reqs[j])) {
                    hunting[j][i] = 0;
                } else {
                    if (i != blocks.size() - 1)
                        hunting[j][i] = Math.min(hunting[j][i], hunting[j][i + 1] + 1);
                }
                val = Math.max(val, hunting[j][i]);
            }
            result[i] = val;
        }

        int min = Integer.MAX_VALUE;
        int position = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] < min) {
                min = result[i];
                position = i;
            }
        }
        return position;
    }

//   Time Complexity (sqr(N)*M)
//   Space Complexity(N)
//    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
//        List<Integer> nearest = new ArrayList<>();
//        for (int i = 0; i < blocks.size(); i++) {
//            Map<String, Boolean> block = blocks.get(i);
//            int nearBySearch = 0;
//            for (String req : reqs) {
//                int left = i - 1;
//                int right = i + 1;
//                boolean existInSameApartment = block.get(req);
//                if (!existInSameApartment) {
//                    int leftSearch = Integer.MAX_VALUE;
//                    int rightSearch = Integer.MAX_VALUE;
//                    if (left >= 0) {
//                        int l = 1;
//                        while (left >= 0) {
//                            if (search(blocks, req, left)) {
//                                leftSearch = l;
//                                break;
//                            } else {
//                                l++;
//                            }
//                            left--;
//                        }
//                    }
//                    if (right < blocks.size()) {
//                        int r = 1;
//                        while (right < blocks.size()) {
//                            if (search(blocks, req, right)) {
//                                rightSearch = r;
//                                break;
//                            } else {
//                                r++;
//                            }
//                            right++;
//                        }
//                    }
//                    nearBySearch = Math.max(nearBySearch, Math.min(leftSearch, rightSearch));
//                }
//            }
//            nearest.add(nearBySearch);
//        }
//        int min = Integer.MAX_VALUE;
//        int position = 0;
//        for (int i = 0; i < nearest.size(); i++) {
//            if (nearest.get(i) < min) {
//                min = nearest.get(i);
//                position = i;
//            }
//        }
//        return position;
//    }
//
//    static boolean search(List<Map<String, Boolean>> blocks, String req, int i) {
//        Map<String, Boolean> block = blocks.get(i);
//        return block.get(req);
//    }
}
