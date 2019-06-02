package by.shumilin.task1.entity;


import by.shumilin.exception.ArrayNotExistException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Array {
    private long[] arr;

    public Array() {
    }

    public Array(long[] arr) {
        this.arr = arr;
    }

    public void sortBubble() throws ArrayNotExistException {
        if (arr == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        for (int barrier = arr.length - 1; barrier > 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (arr[index] > arr[index + 1]) {
                    swap(index, index + 1);
                }
            }
        }
    }

    public void sortSelection() throws ArrayNotExistException {
        if (arr == null) {
            throw new ArrayNotExistException("Массив не существует");
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

    public void sortInsert() throws ArrayNotExistException {

        if (arr == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        long value;
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
        long tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    public long binarySearch(int element) throws ArrayNotExistException {
        if (arr == null) {
            throw new ArrayNotExistException("Массив не существует");
        }

        int position;
        int first = 0;
        int last = arr.length;

        position = (first + last) / 2;

        while ((arr[position] != element) && (first <= last)) {
            if (arr[position] > element) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        return (first <= last) ? position : -1;
    }

    public long maxElement() throws ArrayNotExistException {

        if (arr == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        long max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public long minElement() throws ArrayNotExistException {
        if (arr == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        long min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public List<Long> getSimpleNumbers() throws ArrayNotExistException {
        if (arr == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1)
                if (isPrimeNumber(arr[i])) {
                    list.add(arr[i]);
                }
        }
        return list;
    }

    private static boolean isPrimeNumber(long number) {
        long sqrtNumber = (long) (Math.sqrt(number));
        for (int i = 2; i <= sqrtNumber; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public List<Long> getThreeDigitsNumber() throws ArrayNotExistException {
        if (arr == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 99 && arr[i] < 1000) {
                long first = arr[i] / 100;
                long second = arr[i] / 10 % 10;
                long third = arr[i] % 10;
                if (first != second && second != third && first != third) {
                    list.add(arr[i]);
                }
            }
        }
        return list;
    }

    public void fillArrayRandom(Random random) throws ArrayNotExistException {
        if (arr == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length);
        }
    }

    public void fillArrayScanner(Scanner scanner) throws ArrayNotExistException {
        if (arr == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        for (int i = 0; i < arr.length; i++) {
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            arr[i] = scanner.nextInt();
        }
    }

    public void fillArrayFromFile(File file) throws IOException, ArrayNotExistException {
        if (arr == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        Scanner scanner = new Scanner(file);
        int j = 0;
        while (scanner.hasNext()) {
            if (!scanner.hasNextInt()) {
                scanner.next();
            } else {
                arr[j++] = scanner.nextInt();
            }
        }
    }

    public List<Long> getFibonacciNumbers() throws ArrayNotExistException {
        if (arr == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (isPerfectSquare((5 * arr[i] * arr[i] + 4)) ||
                    isPerfectSquare((5 * arr[i] * arr[i] - 4))) {
                list.add(arr[i]);
            }
        }
        return list;
    }

    private boolean isPerfectSquare(long x) {
        long s = (long) Math.sqrt(x);
        return (s * s == x);
    }

    public long[] getArr() {
        return arr;
    }

    public void setArr(long[] arr) {
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
        for (long element : arr)
            result = (int) (31 * result + element);

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
