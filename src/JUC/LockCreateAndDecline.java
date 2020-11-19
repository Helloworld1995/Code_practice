package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCreateAndDecline {
    public static void main(String[] args) {
        AirConditionOnLock condition=new AirConditionOnLock();
        new Thread(()->{
            try {
                for (int i = 0; i <10 ; i++) {
                    condition.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    condition.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
class AirConditionOnLock{
    private int number=0;
    Lock lock=new ReentrantLock();
    Condition c=lock.newCondition();
    public void increment() throws InterruptedException {
        try{
            lock.lock();
            while(number!=0){
                c.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            c.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void decrement() throws InterruptedException {
        try{
            lock.lock();
            while(number==0){
                c.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            c.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
