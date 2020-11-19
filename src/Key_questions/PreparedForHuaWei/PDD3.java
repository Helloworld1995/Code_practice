package Key_questions.PreparedForHuaWei;

import java.util.*;

public class PDD3 {
    public static String findStr(String s){
        int i=0;
        int j=1;
        int len=s.length();
        Set<Character> set=new HashSet<>();
        for (int k = 0; k <len ; k++) {
            set.add(s.charAt(k));
        }
       List<String> list=new ArrayList<>();

        while(i<len&&j<len){
            if(check(i,j,s,set)){
                list.add(s.substring(i,j+1));
                i++;
            }else {
                j++;
            }
        }
        System.out.println(list.toString());
        return list.get(0);

    }
    public static boolean check(int i,int j,String s,Set<Character> set){
        for (Character c : set) {
            if(s.substring(i,j+1).indexOf(Character.toString(c))==-1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="abcdeee";
        System.out.println(findStr(s));
    }
}
