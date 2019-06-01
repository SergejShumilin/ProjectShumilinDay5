package by.shumilin.task3.regex;

public class CommonRegex {

    public final static String CHANGE_LETTER = "\\w*ра";
    public final static String LENGTH_WORD = "\\b[а-яА-Я]{3}\\b";
//    public final static String REMOVE_SYMBOL = "[^\\pL ]";
    public final static String REMOVE_SYMBOL = "[^а-яА-Я ]";

}
