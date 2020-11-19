package Key_questions;

import java.util.Stack;

/**
 * 括号匹配，只能出现(),{},[]
 */
public class KuoHaoMatch {
    public static void main(String[] args) {
        String s=" '('，')'，'{'，'}'，''，']'";
        boolean match = match(s);
        System.out.println(match);

    }
    public static boolean match(String s){
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            if(stack.isEmpty()){
                return false;
            }
            if (s.charAt(i) == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                }
            } else if (s.charAt(i) == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                }
            } else if (s.charAt(i) == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
