package by.shumilin.task1.entity;

import by.shumilin.task1.exception.ArrayNotExistExeption;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Array {
    private int[] arr;

    public Array() {
    }

    public Array(int[] arr) {
        this.arr = arr;
    }

    public void sortBubble() throws ArrayNotExistExeption {
        if (arr == null) {
            throw new ArrayNotExistExeption("Массив не существует");
        }
        for (int barrier = arr.length - 1; barrier > 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (arr[index] > arr[index + 1]) {
                    swap(index, index + 1);
                }
            }
        }
    }

    public void sortSelection() throws ArrayNotExistExeption {
        if (arr == null) {
            throw new ArrayNotExistExeption("Массив не существует");
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }

    public void sortInsert() throws ArrayNotExistExeption {
        int value;
        if (arr == null) {
            throw new ArrayNotExistExeption("Массив не существует");
        }
        for (int i = 1; i < arr.length; i++) {
            value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = value;
        }
    }

    private void swap(int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    /*не рабочий*/
    public int binarySearch(int item) throws ArrayNotExistExeption {
        if (arr == null) {
            throw new ArrayNotExistExeption("Массив не существует");
        }

        int position;
        int first = 0;
        int last = arr.length;
        // для начала найдем индекс среднего элемента массива
        position = (first + last) / 2;

        while ((arr[position] != item) && (first <= last)) {
            if (arr[position] > item) {  // если число заданного для поиска
                last = position - 1; // уменьшаем позицию на 1.
            } else {
                first = position + 1;    // иначе увеличиваем на 1
            }
            position = (first + last) / 2;
        }
        return (first <= last) ? position : -1;
    }

    public int findMaxElement() throws ArrayNotExistExeption {

        if (arr == null) {
            throw new ArrayNotExistExeption("Массив не существует");
        }

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public int findMinElement() throws ArrayNotExistExeption {
        if (arr == null) {
            throw new ArrayNotExistExeption("Массив не существует");
        }
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public List<Integer> getSimpleNumbers() throws ArrayNotExistExeption {
        if (arr == null) {
            throw new ArrayNotExistExeption("Массив не существует");
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1)
                if (isPrimeNumber(arr[i])) {
                    list.add(arr[i]);
                }
        }
        return list;
    }

    private static boolean isPrimeNumber(int number) {
        int sqrtNumber = (int) (Math.sqrt(number));
        for (int i = 2; i <= sqrtNumber; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public List<Integer> getThreeDigitsNumber() throws ArrayNotExistExeption {
        if (arr == null) {
            throw new ArrayNotExistExeption("Массив не существует");
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 99 && arr[i] < 1000) {
                int first = arr[i] / 100;
                int second = arr[i] / 10 % 10;
                int third = arr[i] % 10;
                if (first != second && second != third && first != third) {
                    list.add(arr[i]);
                }
            }
        }
        return list;
    }

    public int[] fillArrayRandom(Random random) throws ArrayNotExistExeption {
        if (arr == null){
            throw new ArrayNotExistExeption("Массив не существует");
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(30);
        }
        return arr;
    }

    public int[] fillArrayScanner(Scanner scanner) throws ArrayNotExistExeption {
        if (arr == null){
            throw new ArrayNotExistExeption("Массив не существует");
        }
        for (int i = 0; i < arr.length; i++) {
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public int[] fillArrayFromFile(File file) throws FileNotFoundException, ArrayNotExistExeption {
        if (arr == null){
            throw new ArrayNotExistExeption("Массив не существует");
        }
        Scanner scanner = new Scanner(new FileReader(file));
        for (int j = 0; scanner.hasNextInt(); j++) {
            arr[j] = scanner.nextInt();
        }
        return arr;
    }

    public List<Integer> getNumbersFibonacci() throws ArrayNotExistExeption {
        if (arr == null){
            throw new ArrayNotExistExeption("Массив не существует");
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (isPerfectSquare((5 * arr[i] * arr[i] + 4)) ||
                    isPerfectSquare((5 * arr[i] * arr[i] - 4))) {
                list.add(arr[i]);
            }
        }
        return list;
    }

    private boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Array array = (Array) o;

        if (arr == array.arr) return true;
        if (arr == null || array.arr == null) return false;
        if (arr.length != array.arr.length) return false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != array.arr[i]) {
                return false;
            }
        }
        return true;

    }

    @Override
    public int hashCode() {
        if (arr == null)
            return 0;

        int result = 1;
        for (int element : arr)
            result = 31 * result + element;

        return result;
    }

    @Override
    public String toString() {
        if (arr == null)
            return "null";
        int iMax = arr.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
