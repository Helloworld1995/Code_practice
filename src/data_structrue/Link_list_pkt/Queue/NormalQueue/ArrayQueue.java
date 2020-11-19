package data_structrue.Link_list_pkt.Queue.NormalQueue;

import java.util.Arrays;

public class ArrayQueue {
    Object[] queue=null;
    int size;
    public ArrayQueue(){
        size=0;
        queue=new Object[10];
    }
    public synchronized void put(Object o){
        isFull();
        queue[size]=o;
        size++;
    }
    public void isFull(){
        if(size==queue.length){
            queue=Arrays.copyOf(queue,queue.length+10);
        }
    }
    public synchronized Object pop(){
        if(isEmpty()){
            return null;
        }
        Object o=queue[0];
        for (int i = 1; i <size ; i++) {
            queue[i-1]=queue[i];
        }
        size--;
        return o;
    }
    public void print(){
        for (int i = 0; i <size ; i++) {
            System.out.print(queue[i]+"->");
        }
    }
    public boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue();
        for (int i = 0; i <20 ; i++) {
            queue.put(i);
        }
        queue.print();
        queue.pop();
        System.out.println();
        queue.print();

    }
}
