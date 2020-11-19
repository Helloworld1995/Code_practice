package Key_questions;

import java.util.*;

public class RetreateStr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Stack<Word> stack=new Stack<>();
        List<String> words=new ArrayList<>();
        List<String> result=new ArrayList<>();
        String str="";
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(c!=9&&c!=32){
                str+=c;
            }else{
                words.add(str);
                str="";
            }
        }
        words.add(str);
        for (int i = 0; i <words.size() ; i++) {
            String word=words.get(i);
            if(word.equals("undo")){
                if(i-1>=0) {
                    Word w=new Word(i-1,words.get(i-1));
                    stack.push(w);
                    if(!result.isEmpty()) {
                        result.remove(result.size() - 1);
                    }
                }
            }else if(word.equals("redo")){
                if(!stack.isEmpty()){
                    int index=stack.peek().index;
                   String insertS=stack.pop().value;
                   result.add(index,insertS);
                }
            }else{
                result.add(word+" ");
            }
        }
        for (String s1 : result) {
            System.out.print(s1+" ");
        }
    }
}
class Word{
    Integer index;
    String value;
    public Word(Integer index, String value) {
        this.index = index;
        this.value = value;
    }
}
