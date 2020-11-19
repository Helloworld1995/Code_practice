package data_structrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 除去字符串中重复的字符
 */
public class Elimanite_repeated_characters {
    public static String remove(String s){
        char[] cs = s.toCharArray();
        HashSet<Character> set=new HashSet<>();
       StringBuffer sb=new StringBuffer();
        for (int i = 0; i <cs.length ; i++) {
            if(set.add(cs[i])){
                sb.append(cs[i]);
            }
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        String s="goodrf3tqdddd";
        String s1 = remove(s);
        System.out.println(s1);
    }
}
