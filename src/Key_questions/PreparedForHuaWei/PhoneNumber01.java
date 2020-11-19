package Key_questions.PreparedForHuaWei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PhoneNumber01 {
    HashMap<Integer,String> map=new HashMap<>();
    List<String> list=null;
    public PhoneNumber01(){
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        list=new ArrayList<>();
    }
    public static void main(String[] args) {
        PhoneNumber01 pn1=new PhoneNumber01();
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        String digits = String.valueOf(num);
        List<String> list = pn1.letterCombinations(digits, 0, pn1.list, "");
        for (String s : list) {
            System.out.println(s);
        }

    }
    private List<String> letterCombinations(String digits,int i,List<String> list,String s){
        if(i<digits.length()-1) {
            String s1=map.get((int)(digits.charAt(i)-'0'));
            for (int j = 0; j < s1.length(); j++) {
                list=letterCombinations(digits, i + 1, list, s+s1.charAt(j));
            }
        }else{
            String s1=map.get((int)(digits.charAt(i)-'0'));
            for (int j = 0; j <s1.length() ; j++) {
                list.add(s+s1.charAt(j));
            }
        }
        return list;
    }
}
