package io.ylab.university.task1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] arr = getTwoDimensionalArray(5, 5);
        int min = getMinimumNumber(arr);
        int max = getMaximumNumber(arr);
        double average = getAverageNumber(arr);

        System.out.println(Arrays.deepToString(arr));
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.format("Average: %.2f", average);
    }

    public static int[][] getTwoDimensionalArray(int rows, int columns) {
        int[][] array = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = getRandomInt(-10, 100);
            }
        }

        return array;
    }

    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static int getMinimumNumber(int[][] array) {
        int min = array[0][0];

        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                min = ints[j] < min ? ints[j] : min;
            }
        }

        return min;
    }

    public static int getMaximumNumber(int[][] array) {
        int max = array[0][0];

        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                max = ints[j] > max ? ints[j] : max;
            }
        }

        return max;
    }

    public static double getAverageNumber(int[][] array) {

        int sum = 0;
        int amountOfNumbers = array.length * array[0].length;

        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                sum += ints[j];
            }
        }

        return (double) sum / amountOfNumbers;
    }
}
