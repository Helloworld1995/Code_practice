package Key_questions.PreparedForHuaWei;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class M {
    public static void main(String[] args) {
        String s="abcdef\rabcdefg";
        System.out.println(s);
        String reg ="[\n-\r]";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(s);
        s= m.replaceAll("<br/>");
        System.out.println(s);
    }
}
