package data_structrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 反转字符串 i love you--> you love i
 */
public class Reverse_Str {
    public static void swap(char[] cs,int start,int end) {
        while(start<end){
            char temp=cs[start];
            cs[start]=cs[end];
            cs[end]=temp;
            start++;
            end--;
        }
    }
    public static String reverse1(String s){
        int begin=0;
        char[] cs = s.toCharArray();
        swap(cs,begin,s.length()-1);
        System.out.println(new String(cs));
        for (int i = 0; i <cs.length ; i++) {
            if(cs[i]==' ') {
                swap(cs, begin, i - 1);
                begin=i+1;
            }
        }
        return new String(cs);
    }
        public static String reverse2(String s){
            String[] s1 = s.split(" ");
            List<String> list = Arrays.asList(s1);
            Collections.reverse(list);
            return String.valueOf(list);
    }
    public static void main(String[] args) {
        String s="i love to eat BBQ what about you";
        String result = reverse2(s);
        System.out.println(result);

    }
}
