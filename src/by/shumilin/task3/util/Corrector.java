package by.shumilin.task3.util;

import by.shumilin.exception.ArrayNotExistException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Corrector {

    public static void fillArrayConsole(Scanner scanner, String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.nextLine();
        }
    }

    public static void fillArrayFile(String[] strings, File file) throws IOException {
        Scanner scanner = new Scanner(file);
        int i = 0;
        while (scanner.hasNext()) {
                strings[i++] = scanner.next();
        }
    }

    public static void changeLetter(String[] text, int k, char newChar) throws ArrayNotExistException {
        if (text == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        char[] word;
        for (int i = 0; i < text.length; i++) {
            if (text[i]!=null) {
                if (text[i].length() >= k) {
                    word = text[i].toCharArray();
                    word[k - 1] = newChar;
                    text[i] = String.copyValueOf(word);
                }
            }
        }
    }

    /*метод можно применять для заданий 2-4, передавая подходящее под условие регулярное выражение*/
    public static void correctWord(String[] strings, String regex, String text) throws ArrayNotExistException {
        if (text == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i]!=null) {
                strings[i] = strings[i].replaceAll(regex, text);
            }
        }
    }

    public static void formatText(String[] strings, int lengthWord) throws ArrayNotExistException {
        if (strings == null) {
            throw new ArrayNotExistException("Массив не существует");
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null) {
                strings[i] = formatString(strings[i], lengthWord);
            }
        }
    }

    private static String formatString(String incomingText, int lengthWord) {
        StringBuilder sb = new StringBuilder();
        String[] str = incomingText.split(" ");
        for (int i = 0; i < str.length; i++) {
            if ((str[i].length() % lengthWord != 0) && !isVowel(str[i])) {
                sb.append(str[i]).append(" ");
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
