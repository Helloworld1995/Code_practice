package Key_questions;

import java.util.HashSet;
import java.util.Set;

/**
 * 最大不重复子序列
 */
public class LongestNoRepeatedSubStr {
    public static void main(String[] args) {
        String s="123442456801";
        int i=0;
        int j=1;
        String ss="";
        int max=-1;
        while(i<j&&j<s.length()){
            if(check(s,i,j)){
                String str=s.substring(i,j+1);
                int len=str.length();
                if(len>max){
                    max=len;
                    ss=str;
                }
            }else{
                i++;
            }
            j++;
        }
        System.out.println(ss);
    }
    public static boolean check(String s,int i,int j){
        Set<Character> set=new HashSet<>();
        for (int k = i; k <=j ; k++) {
            if(set.add(s.charAt(k))==false){
                return false;
            }
        }
        return true;
    }
}
