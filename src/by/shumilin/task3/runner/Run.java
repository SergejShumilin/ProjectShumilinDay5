package by.shumilin.task3.runner;

import by.shumilin.exception.ArrayNotExsistExeption;
import by.shumilin.task3.regex.CommonRegex;
import by.shumilin.task3.util.Corrector;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        String[] strings = new String[3];
//        List<String> strings = new ArrayList<>();
        Corrector.fillArrayConsole(new Scanner(System.in), strings);

        try {
//            Corrector.changeLetter(strings,4,'a');
            Corrector.correctWord(strings, CommonRegex.REMOVE_SYMBOL, "");
//            Corrector.formatText(strings, 5);
        } catch (ArrayNotExsistExeption arrayNotExsistExeption) {
            arrayNotExsistExeption.printStackTrace();
        }

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
