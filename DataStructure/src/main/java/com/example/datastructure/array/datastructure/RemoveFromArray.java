package com.example.datastructure.array.datastructure;

public class RemoveFromArray {

    public static void removeByIndex(int[] arr, int index) {

        int[] array = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (index == i)
                continue;
            array[j++] = arr[i];
        }

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }

    }
}
