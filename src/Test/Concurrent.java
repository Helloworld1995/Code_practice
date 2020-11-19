package Test;

import java.util.concurrent.ConcurrentHashMap;

public class Concurrent {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> cmap=new ConcurrentHashMap<>();
        cmap.put("呵呵",1243);

    }
}
