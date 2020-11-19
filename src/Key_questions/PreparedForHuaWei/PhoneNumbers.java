package Key_questions.PreparedForHuaWei;

import java.util.*;

/**
 * 电话号码的字母组合
 */
public class PhoneNumbers {
    HashMap<Character,String> map=new HashMap<>();
    {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    public static void main(String[] args) {
        PhoneNumbers pn=new PhoneNumbers();
        HashMap<Integer,String> map=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        String a = sc.nextLine();
        String nums=String.valueOf(a);
        List<String> res = pn.letterCombinations(nums, pn.map);
        for (String s : res) {
            System.out.println(s);
        }
    }
    public List<String> letterCombinations(String digits, HashMap<Character, String> map){
        List<String> list=new ArrayList<>();
        dfs(digits,0,list,"");
        return list;
    }
    private void dfs(String digits,int index,List<String> list,String temp){
        if(temp.length()==digits.length()){
            list.add(temp);
            return;
        }
        String s = map.get(digits.charAt(index++));
        for (int i = 0; i <s.length();i++) {
            dfs(digits,index,list,temp+s.charAt(i));
        }
    }
}
