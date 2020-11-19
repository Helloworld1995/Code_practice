package Key_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 撤回并且复原字符串
 */
public class WithDrawAndResumeStr {
    static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        List<String> words=new ArrayList<>();
        String str="";
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(c==' '||c=='\t'){
                words.add(str);
                str="";
            }else{
                str+=c;
            }
        }
        words.add(str);
        processor(words);

    }
    public static void processor(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals("undo")) {
                if (!stack.isEmpty()) {
                    int peek = stack.peek();
                    int k = peek - 1;
                    while (k >= 0) {
                        String temp = words.get(k);
                        if (temp != "undo" || temp != "redo" || temp != null) {
                            peek = k;
                        }
                        k--;
                    }
                    stack.push(peek);
                }else{
                    if(i>=1) {
                        stack.push(i - 1);
                    }
                }
            } else if (words.get(i).equals("redo")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            for (String word : words) {
                if(word.equals("undo")||word.equals("redo")){
                    continue;
                }
                System.out.print(word + " ");
            }
        } else {
            for (int i = 0; i < words.size(); i++) {
                    if(!stack.isEmpty()) {
                        if (stack.peek() == i) {
                            stack.pop();
                            continue;
                        }
                    }
                    if(words.get(i).equals("undo")||words.get(i).equals("redo")){
                        continue;
                    }
                System.out.print(words.get(i)+" ");
            }
        }
    }
}
