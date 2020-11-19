package Key_questions.HaiKang;

import java.util.*;

/**
 *字符串去重
 */
public class Main01 {
    public static void main(String[] args) {
        elimateRepeated();
    }
    public static void elimateRepeated(){
        List<Character> list=new ArrayList<>();
        StringBuffer sb=new StringBuffer();
        Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
            char[] cs = s.toCharArray();
            for (char c : cs) {
                if(!list.contains(c)){
                    list.add(c);
                }
            }
            for (Character c : list) {
                sb.append(c);
            }
            System.out.println(sb.toString());
   }
}
