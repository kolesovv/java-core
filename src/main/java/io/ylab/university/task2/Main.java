package io.ylab.university.task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};

        int[] sortedArray = bubbleSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] bubbleSort(int[] arr) {

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int j = 0; j < arr.length - 1; j++) {
                int current = arr[j];
                int next = arr[j + 1];
                if (current > next) {
                    arr[j + 1] = current;
                    arr[j] = next;
                    isSorted = false;
                }
            }
        }

        return arr;
    }
}
