package data_structrue.Link_list_pkt.Stack.SimpleStack;

import java.util.Arrays;

public class MyStack<E> {
    private Object[] stack;
    private int size;
    public MyStack(){
        stack=new Object[10];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return (E) stack[size-1];
    }
    public E pop(){
        if(isEmpty()) {
            return null;
        }
        E e= peek();
        stack[size-1]=null;
        size--;
        return e;
    }
    public E push(E item){
        isFull();
        stack[size]=item;
        size++;
        return item;
    }
    public void isFull(){
        int len=stack.length;
        if(size==len){
            int newLen=10;
            stack=Arrays.copyOf(stack,newLen+len);
        }
    }
    public int length(){
        return size;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 0; i <20 ; i++) {
            stack.push(i);
        }
        int len=stack.length();
        for (int i = 0; i <len ; i++) {
            System.out.print(stack.pop()+",");
        }
    }
}
