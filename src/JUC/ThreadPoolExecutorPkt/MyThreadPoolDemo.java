package JUC.ThreadPoolExecutorPkt;

import java.util.concurrent.*;

/**
 * public ThreadPoolExecutor(int corePoolSize,
 *                               int maximumPoolSize,
 *                               long keepAliveTime,
 *                               TimeUnit unit,
 *                               BlockingQueue<Runnable> workQueue,
 *                               ThreadFactory threadFactory,
 *                               RejectedExecutionHandler handler)
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                Runtime.getRuntime().availableProcessors(),
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                /*new ThreadPoolExecutor.DiscardPolicy()*/
                new ThreadPoolExecutor.CallerRunsPolicy());
        try{
            for (int i = 0; i <10; i++) {
                final int temp=i;
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务"+String.valueOf(temp));
                });
//                Thread.sleep(500);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

    }
}
