package data_structrue;

import data_structrue.Link_list_pkt.Queue.NormalQueue.ArrayQueue;
import sun.font.FontRunIterator;

import java.util.*;

/**
 * 怎么消除括号?
 */
public class eliminateKuohao {
    public static String newStr(String str){
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)=='('){
                stack.push('(');
            }else if(str.charAt(i)==')'){
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            return "括号匹配不合法";
        }
        char[] cs=str.toCharArray();
        List<Character>list= new LinkedList<>();
        for (int i = 0; i <cs.length ; i++) {
            list.add(cs[i]);
        }
        List<Character> eliminate=new ArrayList<>();
        eliminate.add('(');
        eliminate.add(')');
        list.removeAll(eliminate);
        list.add(0,'(');
        list.add(list.size(),')');
        char[] result=new char[list.size()];
        for (int i = 0; i <list.size() ; i++) {
                result[i] = list.get(i);
        }
        return new String(result);
    }
    public static String eliminateKuoHao(String str){
        String result="(";
        char[] c = str.toCharArray();
        int i=0;
        int kuohao=0;
        int size=c.length;
        while(i<size) {
            if (c[i] == '(') {
                kuohao++;
            } else if (c[i] == ')') {
                if (kuohao > 0) {
                    kuohao--;
                } else {
                    return "括号不匹配";
                }
            } else {
                result += c[i];
            }
            i++;
        }
            if(kuohao!=0){
                return "括号不匹配";
            }
            result+=')';
            return result;
        }
    public static void main(String[] args) {
        String s="(1,(2,3),(4,(5,6),7))";
        String result=eliminateKuoHao(s);
        System.out.println(result);
    }
}
