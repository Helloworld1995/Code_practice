package data_structrue;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 判断两个字符串是否由相同的字符组成
 */
public class Check_2str_same_characters {
    public static boolean isSame(String s1,String s2){
        byte[] s1Bytes = s1.getBytes();
        byte[] s2Bytes= s2.getBytes();
        Arrays.sort(s1Bytes);
        Arrays.sort(s2Bytes);
        s1=new String(s1Bytes);
        s2=new String(s2Bytes);
        if(s1.equals(s2)){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isEqual(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        char[] b1 = s1.toCharArray();
        char[] b2=s2.toCharArray();
        int[] map=new int[256];
        for (int i = 0; i <b1.length; i++) {
            map[b1[i]-'0']++;
        }
        for (int i = 0; i <b2.length ; i++) {
            map[b2[i]-'0']--;
        }
        for (int i = 0; i <map.length ; i++) {
            if(map[i]!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1="aaaaaabbccdv";
        String s2="bcdacbaaaaac";
        boolean same = isSame(s1, s2);
        boolean equal = isEqual(s1, s2);
        System.out.println(same);
        System.out.println(equal);
    }
}
