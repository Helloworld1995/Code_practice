package Key_questions.slidingWindows;

import java.util.Arrays;

/**
 * 判断字符串s1是否包含s2的排列
 */
public class StrInclusion {
    public static void main(String[] args) {
        String s1="ab";
        String s2="eidboaboo";
        boolean b = check(s1, s2);
        System.out.println(b);
    }
    public static boolean check(String s1,String s2){
        if(s1.length()>s2.length()){
            return false;
        }
        int i = 0,j=0;
        j=s1.length()-1;
        while(j<s2.length()&&i<=j){
            String sub1=s2.substring(i,j+1);
            if(judge(sub1,s1)){
                return true;
            }
            i++;
            j++;
        }
        return false;
    }
    public static boolean judge(String sub,String s){
        char[] csub = sub.toCharArray();
        char[] cs = s.toCharArray();
        Arrays.sort(csub);
        Arrays.sort(cs);
        if(new String(csub).equals(new String(cs))){
            return true;
        }else{
            return  false;
        }
    }
}
