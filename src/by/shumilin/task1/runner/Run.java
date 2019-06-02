package by.shumilin.task1.runner;

import by.shumilin.exception.ArrayNotExistException;
import by.shumilin.task1.entity.Array;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Run {
    public static void main(String[] args) {
        Array array = new Array(new long[10]);
        try {
//            array.fillArrayScanner(new Scanner(System.in));
//            array.fillArrayFromFile(new File("E:/data.txt"));
//            array.fillArrayRandom(new Random());
            array.sortInsert();
            System.out.println(array);
            System.out.println(array.binarySearch(7));
//            System.out.println(array.getThreeDigitsNumber());
        } catch (ArrayNotExistException arrayNotExistException) {
            arrayNotExistException.printStackTrace();
        }
    }
}
