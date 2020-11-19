package Key_questions.PreparedForHuaWei;

import java.util.HashMap;
import java.util.Map;

public class LeetCode48 {
    private static int lengthOfLongestSubstring(String s){
        int len=s.length();
        if(len==0||s==null){
            return 0;
        }
        Map<Character,Integer> map=new HashMap<>();
        int l=-1,max=-1;
        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if(map.containsKey(c)){
                l=Math.max(l,map.get(c));
            }
            map.put(c,i);
            max=Math.max(max,i-l);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
