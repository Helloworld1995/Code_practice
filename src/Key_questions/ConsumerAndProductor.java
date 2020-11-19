package Key_questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class ConsumerAndProductor {
    public static void main(String[] args) {
       MyQueue mq=new MyQueue();
        new Thread(new Insert(mq)).start();
        new Thread(new Pop(mq)).start();
    }
}

class MyQueue{
    Queue<Object> queue=new LinkedList<>();
}
class Insert implements Runnable{
    MyQueue queue;
    public Insert(MyQueue queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        synchronized (queue){
            while(true) {
                while(queue.queue.size()<=10){
                    int k= (int) (Math.random()*100);
                    queue.queue.offer(k);
                    System.out.print(Thread.currentThread().getName()+":"+k+" ");
                }
                queue.notify();
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Pop implements Runnable{

    MyQueue queue;
    public Pop(MyQueue queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        synchronized (queue){
            while(true) {
                while(queue.queue.size()>10){
                    int q= (int) queue.queue.poll();
                    System.out.print(Thread.currentThread().getName()+":"+q+" ");
                }
                queue.notify();
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
