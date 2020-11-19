package JUC;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);//模拟资源类有多少个，如3
        for (int i = 0; i <=6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//被该线程抢占信号量-1
                    System.out.println(Thread.currentThread().getName()+"\t抢占到了车位");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//信号量+1
                    System.out.println(Thread.currentThread().getName()+"\t离开了车位");
                }
            },String.valueOf(i)).start();
        }
    }
}
