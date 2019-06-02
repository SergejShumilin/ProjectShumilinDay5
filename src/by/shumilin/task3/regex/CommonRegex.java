package by.shumilin.task3.regex;

public class CommonRegex {
    private static int length = 4;
    public final static String CHANGE_LETTER = "\\w*ра";
    public final static String LENGTH_WORD = "\\b[a-zA-Z]{" + length + "}\\b";
//    public final static String REMOVE_SYMBOL = "[^\\pL ]";
    public final static String REMOVE_SYMBOL_NOT_CHARACTER = "[^a-zA-Z ]";

}
