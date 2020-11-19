package JUC;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread2 myThread2=new MyThread2();
        FutureTask<Integer> task=new FutureTask(myThread2);
        new Thread(task,"A").start();
        Thread.sleep(6000);
        task.cancel(true);
        Integer result= task.get();
        System.out.println(result);
    }
}
class MyThread implements Runnable{

    @Override
    public void run() {

    }
}
class MyThread2 implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        while(true) {
            if(Thread.interrupted()) {
                break;
            }
            System.out.println("****come in call method()");
            Thread.sleep(2000);
        }
            return 1024;

    }
}
