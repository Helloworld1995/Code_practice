package Key_questions.PreparedForHuaWei;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度（子串==连续）
 */
public class NoRepeatedSubArr {
    public static void main(String[] args) {
        String s="bbbabcde";
        char[] cs = s.toCharArray();
        int i=0;
        int j=0;
        int max=-1;
        int start=0;
        int end=0;
        while(i<=j&&j<cs.length){
            boolean bool = isReapted(i, j, cs);
            if(bool){
                int len=j-i;
                if(len>max){
                    max=len;
                    start=i;
                    end=j;
                }
                j++;
            }else {
                i++;
            }
        }
        System.out.println(s.substring(start,end+1));
    }
    private static boolean isReapted(int start,int end,char[] cs){
        Set<Character> set=new HashSet<>();
        for (int i = start; i <=end ; i++) {
            if(!set.add(cs[i])){
                return false;
            }
        }
        return true;
    }
}
