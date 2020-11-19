package Key_questions;

/**
 * 两个字符串的最长公共子串
 */
public class TwoStrLongestSub {
    public static void main(String[] args) {
        String s1="abcdefghijk";
        String s2="abdefgijkg";
        String str="";
        int max=-1;
        for (int i = 0; i <s1.length() ; i++) {
            for (int j = 0; j <s2.length() ; j++) {
                if(s1.charAt(i)==s2.charAt(j)){
                    String s="";
                    int k1=i;
                    int k2=j;
                    while(k1<s1.length()&&k2<s2.length()){
                        if(s1.charAt(k1)==s2.charAt(k2)){
                            s+=s1.charAt(k1);
                            k1++;
                            k2++;
                        }else{
                            break;
                        }
                    }
                    if(s.length()>max){
                        max=s.length();
                        str=s;
                    }
                }
            }
        }
        System.out.println(str);
    }
}
