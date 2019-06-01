package by.shumilin.task3.util;

import by.shumilin.exception.ArrayNotExsistExeption;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Corrector {

    public static void fillArrayConsole(Scanner scanner, String[] strings) {
        for (int i = 0; i < strings.length; i++) {
                strings[i] = scanner.nextLine();
        }
    }

    public static void fillArrayFile(Scanner scanner, List<String> strings) throws IOException {
        while (scanner.hasNext()) {
            strings.add(scanner.nextLine());
        }
    }

    public static void changeLetter(String[] text, int k, char newChar) throws ArrayNotExsistExeption {
        if (text == null){
            throw new ArrayNotExsistExeption("Массив не существует");
        }
        char[] word;
        for (int i = 0; i < text.length; i++) {
            if (text[i].length() >= k) {
                word = text[i].toCharArray();
                word[k - 1] = newChar;
                text[i] = String.copyValueOf(word);
            }
        }
    }

    /*метод можно применять для заданий 2-4, передавая подходящее под условие регулярное выражение*/
    public static void correctWord(String[] strings, String regex, String text) throws ArrayNotExsistExeption {
        if (text == null){
            throw new ArrayNotExsistExeption("Массив не существует");
        }
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replaceAll(regex, text);
        }
    }

//    public static void subWord(String[] strings, String regex, String word){
//        for (int i = 0; i < strings.length; i++) {
//            strings[i] = strings[i].replaceAll(regex, word);
//        }
//    }
//
//    public static void replace(String[] strings, String regex) {
//        for (int i = 0; i < strings.length; i++) {
//            strings[i] = strings[i].replaceAll(regex, "");
//        }
//    }

    public static void formatText(String[] strings, int lengthWord) throws ArrayNotExsistExeption {
        if (strings == null){
            throw new ArrayNotExsistExeption("Массив не существует");
        }
        for (int i = 0; i < strings.length; i++) {
            strings[i] = formatText(strings[i], lengthWord);
        }
    }

    private static String formatText(String incomingText, int lengthWord) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = incomingText.split(" ");
        for (int i = 0; i < strArr.length; i++) {

            if ((strArr[i].length() % lengthWord != 0) && !isVowel(strArr[i])) {
                sb.append(strArr[i]).append(" ");
            }
        }

        String outText = sb.toString().trim();
        return outText;
    }

    private static boolean isVowel(String incomingText) {
        switch (incomingText.charAt(0)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return true;
            default:
                return false;

        }
    }



}
