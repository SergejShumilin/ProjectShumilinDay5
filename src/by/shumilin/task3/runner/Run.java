package by.shumilin.task3.runner;

import by.shumilin.exception.ArrayNotExistException;
import by.shumilin.task3.regex.CommonRegex;
import by.shumilin.task3.util.Corrector;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws IOException {
        String[] strings = new String[10];

//        Corrector.fillArrayConsole(new Scanner(System.in), strings);
        Corrector.fillArrayFile(strings, new File("E:/data.txt"));

        try {
            Corrector.changeLetter(strings, 1, 'a');
//            Corrector.correctWord(strings, CommonRegex.LENGTH_WORD, "!!!");
//            Corrector.formatText(strings, 5);
        } catch (
                ArrayNotExistException arrayNotExistException) {
            System.out.println(arrayNotExistException.getMessage());
        }

        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
}
