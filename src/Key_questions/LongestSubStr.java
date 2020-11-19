package Key_questions;

/**
 * 题目描述：删除 s 中的一些字符，
 * 使得它构成字符串列表 d 中的一个字符串，
 * 找出能构成的最长字符串。如果有多个
 * 相同长度的结果，返回字典序的最小字符串
 */
public class LongestSubStr {
    public static void main(String[] args) {
        String[] d={"able","apple","monkey","plea"};
        String s="abpcplea";
        int max=-1;
        String maxSub="";
        for (String d1 : d) {
            if(d1.length()>s.length()){
                continue;
            }
            if(isSubStr(s,d1)){
                if(max<d1.length()){
                    max=d1.length();
                    maxSub=d1;
                }
            }
        }
        System.out.println(maxSub);
    }
    public static boolean isSubStr(String s,String d){
        int i=0;
        int j=0;
        while(i<s.length()&&j<d.length()){
            if(s.charAt(i)==d.charAt(j)){
                j++;
            }
            i++;
        }
        return j==d.length();
    }
}
