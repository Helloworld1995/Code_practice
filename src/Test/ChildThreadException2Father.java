package Test;

import ClonePkt.CloneTest;

import java.util.concurrent.*;

public class ChildThreadException2Father {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 100 / 10;
            }
        });
        t.start();
        callableTest ct = new callableTest();
        FutureTask future = new FutureTask(ct);
        try {
            ExecutorService executorService= Executors.newCachedThreadPool();
            executorService.submit(future);
            Thread.sleep(1000);
            Object o = future.get();
//            future.cancel(false);
            System.out.println(((int)o));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.println(Thread.currentThread().getName() + "is going");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
    class callableTest implements  Callable{
        int i=10;
        int k=-1;
        @Override
        public Object call() throws Exception {
            while(i>=0){
                i--;
                Thread.sleep(200);
                try{
                    k=100/i;
                }catch (ArithmeticException e){
                    e.getMessage();
                }finally {
                    i++;
                    System.out.println(k);
                }
            }
            return k;
        }
    }



