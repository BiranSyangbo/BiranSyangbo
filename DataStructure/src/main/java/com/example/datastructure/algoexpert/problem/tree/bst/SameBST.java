package com.example.datastructure.algoexpert.problem.tree.bst;

import java.util.*;

public class SameBST {


    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size() || (!arrayOne.get(0).equals(arrayTwo.get(0))))
            return false;

        Map<Integer, Integer> resultOne = new HashMap<>(arrayOne.size());
        Map<Integer, Integer> resultTwo = new HashMap<>(arrayTwo.size());
        for (int i = 0; i < arrayOne.size(); i++) {
            int j = i + 1;
            int count = 0;
            Integer left = null;
            Integer right = null;
            while (j < arrayOne.size() && count < 2) {
                if (!resultOne.containsKey(arrayOne.get(i))) {
                    if (count == 0) {
                        if (arrayOne.get(i) > arrayOne.get(j)) {
                            left = arrayOne.get(j);
                            resultOne.put(left, arrayOne.get(i));
                            count++;
                            j = i;
                        }
                    } else {
                        if (arrayOne.get(i) < arrayOne.get(j)) {
                            right = arrayOne.get(j);
                            resultOne.put(right, arrayOne.get(i));
                            count++;
                            j = i;
                        }
                    }
                } else {
                    if (count == 0) {
                        if (arrayOne.get(i) > arrayOne.get(j) && resultOne.get(arrayOne.get(i)) > arrayOne.get(j)) {
                            left = arrayOne.get(j);
                            resultOne.put(left, arrayOne.get(i));
                            count++;
                            j = i;
                        }
                    } else {
                        if (arrayOne.get(i) < arrayOne.get(j) && resultOne.get(arrayOne.get(i)) < arrayOne.get(j)) {
                            right = arrayOne.get(j);
                            resultOne.put(right, arrayOne.get(i));
                            count++;
                            j = i;
                        }
                    }
                }
                j++;
            }
            count = 0;
            j = i + 1;
            Integer rightTwo = null;
            Integer leftTwo = null;
            while (j < arrayTwo.size() && count < 2) {
                if (!resultTwo.containsKey(resultTwo.get(i))) {
                    if (count == 0) {
                        if (arrayTwo.get(i) > arrayTwo.get(j)) {
                            leftTwo = arrayTwo.get(j);
                            resultTwo.put(leftTwo, arrayTwo.get(i));
                            count++;
                            j = i;
                        }
                    } else {
                        if (arrayTwo.get(i) < arrayTwo.get(j)) {
                            rightTwo = arrayTwo.get(j);
                            resultTwo.put(leftTwo, arrayTwo.get(i));
                            count++;
                            j = i;
                        }
                    }
                } else {
                    if (count == 0) {
                        if (arrayTwo.get(i) > arrayTwo.get(j) && resultTwo.get(arrayTwo.get(i)) > arrayTwo.get(j)) {
                            leftTwo = arrayOne.get(j);
                            resultTwo.put(rightTwo, arrayOne.get(i));
                            count++;
                            j = i;
                        }
                    } else {
                        if (arrayTwo.get(i) < arrayTwo.get(j) && resultTwo.get(arrayTwo.get(i)) < arrayTwo.get(j)) {
                            rightTwo = arrayTwo.get(j);
                            resultTwo.put(rightTwo, arrayTwo.get(i));
                            count++;
                            j = i;
                        }
                    }
                }
                j++;
            }
            if (right != rightTwo && left != leftTwo)
                return false;
        }
        return true;
    }
}
