package JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache=new MyCache();
        for (int i = 0; i < 4; i++) {
            final int tempInt = i;
            new Thread(() -> {
                cache.put(String.valueOf(tempInt), new Object());
            }, String.valueOf(i)).start();
        }
        for (int i = 0; i < 4; i++) {
            final int tempInt = i;
            new Thread(()->{
                cache.get(String.valueOf(tempInt));
            },String.valueOf(i)).start();
        }
    }
}
class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
       try{
           System.out.println(Thread.currentThread().getName()+"\t---写入数据"+key);
           Thread.sleep(300);
           map.put(key,value);
           System.out.println(Thread.currentThread().getName()+"\t---写入完成");
       }catch (Exception e){
           e.printStackTrace();
       }finally {
        readWriteLock.writeLock().unlock();
       }
    }
    public void get(String key){
        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t---读取数据"+key);
            Thread.sleep(300);
            Object res = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t---读取完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        readWriteLock.readLock().unlock();
        }
    }

}
