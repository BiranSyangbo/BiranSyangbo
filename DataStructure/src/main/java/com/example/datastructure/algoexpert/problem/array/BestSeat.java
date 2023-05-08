package com.example.datastructure.algoexpert.problem.array;

public class BestSeat {

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1};
        System.out.println("bestSeats = " + bestSeat(arr));
    }

    static int bestSeat(int[] seats) {
        if (seats.length < 2)
            return -1;
        if (seats.length == 2 && seats[1] == 0)
            return 1;
        int seat = -1;
        int start = 1;
        int diff = -1;
        while (start < seats.length - 1) {
            if (seats[start] == 0) {
                int s = start;
                while (seats[start + 1] == 0) {
                    start++;
                }
                int d = start - s;
                if (d > diff) {
                    seat = s + (d) / 2;
                }
                diff = d;
            }
            start++;
        }
        return seat;
    }


}
