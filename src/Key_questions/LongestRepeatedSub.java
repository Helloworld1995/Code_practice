package Key_questions;

import java.util.*;

public class LongestRepeatedSub {
    public static void main(String[] args) {
        String s="bbbbbbaaaaaaaaccccccccddeefdaab";
        func(s);

    }
    private static void func(String s){
        Map<Integer,String> map=new HashMap<>();
        int left=0;
        int right=0;
        int count=0;
        int max=-1;
        char c='0';
        while(right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                right++;
                count++;
            }else{
                if(max<=count){
                    max=count;
                    c=s.charAt(left);
                    if(!map.containsKey(count)){
                        map.put(count,String.valueOf(c));
                    }else{
                        String s1 = map.get(count);
                        s1+=c;
                        map.put(count,s1);
                    }
                }
                left=right;
                count=0;
            }
        }
        int maxVlaue=-1;
        for (Integer i : map.keySet()) {
            if(maxVlaue<=i){
                maxVlaue=i;
            }
        }
        String str = map.get(maxVlaue);
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i)+" ");
        }


    }
}
