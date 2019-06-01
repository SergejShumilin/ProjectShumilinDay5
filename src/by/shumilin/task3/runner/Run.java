package by.shumilin.task3.runner;

import by.shumilin.exception.ArrayNotExistException;
import by.shumilin.task3.regex.CommonRegex;
import by.shumilin.task3.util.Corrector;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        String[] strings = new String[3];

        Corrector.fillArrayConsole(new Scanner(System.in), strings);

        try {
//            Corrector.changeLetter(strings,4,'a');
            Corrector.correctWord(strings, CommonRegex.LENGTH_WORD, "!!!");
//            Corrector.formatText(strings, 5);
        } catch (
    ArrayNotExistException arrayNotExsistExeption) {
            System.out.println(arrayNotExsistExeption.getMessage());
        }

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
