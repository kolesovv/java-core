package io.ylab.university.task2;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class MainTest {

    @Test
    public void bubbleSort_arrayExist_sortedArrayIsReturned() {

        //GIVEN
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {0, 0, 0, 2, 1};
        int[] arr3 = {2, 1, 0, 0, 0};
        int[] arr4 = {-10, 10, -5, 5, 0};
        int[] arr5 = {100, 99};
        int[] arr6 = {9, 8, 7, 6, 5};

        int[] sortedArr1 = {1, 2, 3, 4, 5};
        int[] sortedArr2 = {0, 0, 0, 1, 2};
        int[] sortedArr3 = {0, 0, 0, 1, 2};
        int[] sortedArr4 = {-10, -5, 0, 5, 10};
        int[] sortedArr5 = {99, 100};
        int[] sortedArr6 = {5, 6, 7, 8, 9};

        //WHEN
        int[] returnedSortedArr1 = Main.bubbleSort(arr1);
        int[] returnedSortedArr2 = Main.bubbleSort(arr2);
        int[] returnedSortedArr3 = Main.bubbleSort(arr3);
        int[] returnedSortedArr4 = Main.bubbleSort(arr4);
        int[] returnedSortedArr5 = Main.bubbleSort(arr5);
        int[] returnedSortedArr6 = Main.bubbleSort(arr6);

        //THEN
        assertArrayEquals(sortedArr1, returnedSortedArr1);
        assertArrayEquals(sortedArr2, returnedSortedArr2);
        assertArrayEquals(sortedArr3, returnedSortedArr3);
        assertArrayEquals(sortedArr4, returnedSortedArr4);
        assertArrayEquals(sortedArr5, returnedSortedArr5);
        assertArrayEquals(sortedArr6, returnedSortedArr6);
    }
}