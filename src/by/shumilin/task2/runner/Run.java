package by.shumilin.task2.runner;

import by.shumilin.exception.ArrayNotExistException;
import by.shumilin.task2.entity.Array;

import java.util.Arrays;

public class Run {

    public static void main(String[] args) {

        int[][] arr = {{1, 9, 12},
                       {2, 6, 2, 46},
                       {3, 3, 3, 1, 47},
                       {4, 4, 4, 4, 8, 15}};

        Array array = new Array();
//        array.setArr(arr);
        try {
            Array.sortByLineSumDecrease(arr);
//            Array.sortByLineSumIncrease(arr);
//        Array.sortByLineMaxElementIncrease(arr);
//        Array.sortByLineMaxElementDecrease(arr);
//        Array.sortByLineMinElementDecrease(arr);
//        Array.sortByLineMinElementIncrease(arr);
        } catch (ArrayNotExistException arrayNotExsistExeption) {
            arrayNotExsistExeption.printStackTrace();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}

