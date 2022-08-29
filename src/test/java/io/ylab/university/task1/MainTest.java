package io.ylab.university.task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    private final int[][] arr1 = {{1, 2, 3}, {-1, -2, -3}, {4, 5, 6}};
    private final int[][] arr2 = {{1, 2, 3}, {-1, -2, -3}};
    private final int[][] arr3 = {{1, 2, 3}};


    @Test
    public void getMinimumNumber_arrayExist_minimumNumberIsReturned() {

        //GIVEN
        int minOfArr1 = -3;
        int minOfArr2 = -3;
        int minOfArr3 = 1;

        //WHEN
        int returnedMinOfArr1 = Main.getMinimumNumber(arr1);
        int returnedMinOfArr2 = Main.getMinimumNumber(arr2);
        int returnedMinOfArr3 = Main.getMinimumNumber(arr3);

        //THEN
        assertEquals(minOfArr1, returnedMinOfArr1);
        assertEquals(minOfArr2, returnedMinOfArr2);
        assertEquals(minOfArr3, returnedMinOfArr3);
    }

    @Test
    public void getMaximumNumber_arrayExist_maximumNumberIsReturned() {

        //GIVEN
        int maxOfArr1 = 6;
        int maxOfArr2 = 3;
        int maxOfArr3 = 3;

        //WHEN
        int returnedMaxOfArr1 = Main.getMaximumNumber(arr1);
        int returnedMaxOfArr2 = Main.getMaximumNumber(arr2);
        int returnedMaxOfArr3 = Main.getMaximumNumber(arr3);

        //THEN
        assertEquals(maxOfArr1, returnedMaxOfArr1);
        assertEquals(maxOfArr2, returnedMaxOfArr2);
        assertEquals(maxOfArr3, returnedMaxOfArr3);
    }

    @Test
    public void getAverageNumber_arrayExist_averageNumberIsReturned() {

        //GIVEN
        double averageOfArr1 = 1.66;
        double averageOfArr2 = 0;
        double averageOfArr3 = 2;

        //WHEN
        double returnedAverageOfArr1 = Main.getAverageNumber(arr1);
        double returnedAverageOfArr2 = Main.getAverageNumber(arr2);
        double returnedAverageOfArr3 = Main.getAverageNumber(arr3);

        //THEN
        assertEquals(averageOfArr1, returnedAverageOfArr1, 2);
        assertEquals(averageOfArr2, returnedAverageOfArr2, 2);
        assertEquals(averageOfArr3, returnedAverageOfArr3, 2);
    }
}