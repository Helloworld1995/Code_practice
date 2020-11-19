package JUC.ThreadPoolExecutorPkt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = null;
//        threadPool= Executors.newFixedThreadPool(5); //1池5线程，Excutors线程池接口。Collections集合接口。Arrays数组接口。
//        threadPool=Executors.newSingleThreadExecutor();//一池一线程
        threadPool = Executors.newCachedThreadPool();//1池N线程
        try{
            for (int i = 0; i <10 ; i++) {
                final int temp=i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务"+String.valueOf(temp));
                });
//                Thread.sleep(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }

    }
}
