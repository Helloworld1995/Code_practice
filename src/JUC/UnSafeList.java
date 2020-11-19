package JUC;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class UnSafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new CopyOnWriteArrayList<>();/*Collections.synchronizedList(new ArrayList<>());*/
        for (int i = 0; i <50 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
            },String.valueOf(i)).start();
        }
        while(!list.isEmpty()){
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
