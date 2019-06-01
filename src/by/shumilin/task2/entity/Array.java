package by.shumilin.task2.entity;

import by.shumilin.exception.ArrayNotExsistExeption;

public class Array {
    int[][] arr;

    public int[][] getArr() {
        return arr;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }

    public static void sortByLineSumDecrease(int[][] arr) throws ArrayNotExsistExeption {
        if (arr == null){
            throw new ArrayNotExsistExeption("Массив не существует");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (calcLineSum(arr[j]) < calcLineSum(arr[j + 1])) {
                    swap(arr, j);
                }
            }
        }
    }

    public static void sortByLineSumIncrease(int[][] arr) throws ArrayNotExsistExeption {
        if (arr == null){
            throw new ArrayNotExsistExeption("Массив не существует");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (calcLineSum(arr[j]) > calcLineSum(arr[j + 1])) {
                    swap(arr, j);
                }
            }
        }
    }

    private static int calcLineSum(int[] line) {
        int result = 0;
        for (int val : line) {
            result += val;
        }
        return result;
    }

    public static void sortByLineMaxElementIncrease(int[][] arr) throws ArrayNotExsistExeption {
        if (arr == null){
            throw new ArrayNotExsistExeption("Массив не существует");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (searchMaxElement(arr[j]) > searchMaxElement(arr[j + 1])) {
                    swap(arr, j);
                }
            }
        }
    }

    public static void sortByLineMaxElementDecrease(int[][] arr) throws ArrayNotExsistExeption {
        if (arr == null){
            throw new ArrayNotExsistExeption("Массив не существует");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (searchMaxElement(arr[j]) < searchMaxElement(arr[j + 1])) {
                    swap(arr, j);
                }
            }
        }
    }

    private static int searchMaxElement(int[] line) {
        int max = 0;
        for (int i = 0; i < line.length; i++) {
            if (line[i] > max) {
                max = line[i];
            }
        }
        return max;
    }

    public static void sortByLineMinElementDecrease(int[][] arr) throws ArrayNotExsistExeption {
        if (arr == null){
            throw new ArrayNotExsistExeption("Массив не существует");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (searchMinElement(arr[j]) < searchMinElement(arr[j + 1])) {
                    swap(arr, j);
                }
            }
        }
    }

    public static void sortByLineMinElementIncrease(int[][] arr) throws ArrayNotExsistExeption {
        if (arr == null){
            throw new ArrayNotExsistExeption("Массив не существует");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (searchMinElement(arr[j]) > searchMinElement(arr[j + 1])) {
                    swap(arr, j);
                }
            }
        }
    }

    private static int searchMinElement(int[] line) {
        int min = line[0];
        for (int i = 0; i < line.length; i++) {
            if (line[i] < min) {
                min = line[i];
            }
        }
        return min;
    }

    private static void swap(int[][] arr, int j) {
        int[] buffLine = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = buffLine;
    }
}

