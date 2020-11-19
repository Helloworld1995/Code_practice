package Key_questions;

import java.util.Stack;

/**
 * 两个栈构成一个栈
 */
public class TwoStackBeQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public TwoStackBeQueue(){
        s1=new Stack<>();
        s2=new Stack<>();
    }
    public void add(int item){
        s1.push(item);
    }
    public int poll(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public int peek(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    public boolean isEmplty(){
        return s2.isEmpty();
    }

    public static void main(String[] args) {
        TwoStackBeQueue queue=new TwoStackBeQueue();
        int[] arr={1,2,3,4,5,6,7,8};
        for (int a : arr) {
            queue.add(a);
        }
        System.out.println(queue.poll());

    }
}



