package com.example.datastructure.algoexpert.problem.graph.array;

import java.util.*;

public class ApartmentHunting {

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        List<Integer> nearest = new ArrayList<>();
        for (int i = 0; i < blocks.size(); i++) {
            Map<String, Boolean> block = blocks.get(i);
            int nearBySearch = 0;
            for (String req : reqs) {
                int left = i - 1;
                int right = i + 1;
                boolean existInSameApartment = block.get(req);
                if (!existInSameApartment) {
                    int leftSearch = Integer.MAX_VALUE;
                    int rightSearch = Integer.MAX_VALUE;
                    if (left >= 0) {
                        int l = 1;
                        while (left >= 0) {
                            if (search(blocks, req, left)) {
                                leftSearch = l;
                                break;
                            } else {
                                l++;
                            }
                            left--;
                        }
                    }
                    if (right < blocks.size()) {
                        int r = 1;
                        while (right < blocks.size()) {
                            if (search(blocks, req, right)) {
                                rightSearch = r;
                                break;
                            } else {
                                r++;
                            }
                            right++;
                        }
                    }
                    nearBySearch = Math.max(nearBySearch, Math.min(leftSearch, rightSearch));
                }
            }
            nearest.add(nearBySearch);
        }
        int min = Integer.MAX_VALUE;
        int position = 0;
        for (int i = 0; i < nearest.size(); i++) {
            if (nearest.get(i) < min) {
                min = nearest.get(i);
                position = i;
            }
        }
        return position;
    }

    static boolean search(List<Map<String, Boolean>> blocks, String req, int i) {
        Map<String, Boolean> block = blocks.get(i);
        return block.get(req);
    }
}
