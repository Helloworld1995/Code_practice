package LanQiao;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2个线程(一个输出1，一个输出0,打印010101.....)
 */
public class TwoThread {
    public static void main(String[] args) {
       Process process=new Process(20);
       Runnable r1=new incrementThread01(process);
//        Runnable r2=new incrementThread02(process);
        Runnable r3=new decrementThread01(process);
//        Runnable r4=new decrementThread02(process);
       Thread t=new Thread(r1);
//       Thread t1=new Thread(r2);
        Thread t2=new Thread(r3);
//        Thread t3=new Thread(r4);
        t.start();
//        t1.start();
        t2.start();
//        t3.start();

    }

}
class Process{

    int size;
    public Process(int size){
        this.size=size;

    }
    public void increment() throws InterruptedException {
        while(size>0) {
            this.wait();
            System.out.print("1");
            this.notify();
            Thread.sleep(500);
            size--;
        }
    }
    public void decrement() throws InterruptedException {
        while(size>0) {
            this.notify();
            this.wait();
            System.out.print("0");
            Thread.sleep(500);
            size--;
        }
    }
}
class incrementThread01 implements Runnable {
    private Process process;
    public incrementThread01(Process process) {
        this.process = process;
    }
    @Override
    public void run() {
        try {
            synchronized (process) {
                process.increment();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//class incrementThread02 implements Runnable{
//    private Process process;
//    public incrementThread02(Process process){
//        this.process=process;
//    }
//    @Override
//    public void run() {
//        for (int i = 0; i <process.size ; i++) {
//            process.increment();
//        }
//
//    }
//}
class decrementThread01 implements Runnable{
    private Process process;
    public decrementThread01(Process process){
        this.process=process;
    }
    @Override
    public void run() {
        try {
            synchronized (process) {
                process.decrement();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }


//class decrementThread02 implements Runnable{
//    private Process process;
//    public decrementThread02(Process process){
//        this.process=process;
//    }
//    @Override
//    public void run() {
//        for (int i = 0; i <process.size ; i++) {
//            process.decrement();
//        }
//    }
//}