package by.shumilin.task1;

import by.shumilin.task1.entity.Array;
import by.shumilin.task1.exception.ArrayNotExistExeption;

public class Main {
    public static void main(String[] args) {
        Array array = new Array();
        int[] arr = null;
//        int[] arr = new int[10];
//        int[] arr = {201, 3, 100, 499, 576, 5, 2, 7, 2};
//        int [] arr = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        array.setArr(arr);
        System.out.println(array);
        try {
            array.sortInsert();
            System.out.println(array.binarySearch(7));
        } catch (ArrayNotExistExeption arrayNotExistExeption) {
            System.out.println(arrayNotExistExeption.getMessage());
        }
    }
}
