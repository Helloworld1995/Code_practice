package ThreadLocalStudy;

import Test.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;

public class ThreadLocalTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
       ThreadLocal local=new ThreadLocal();
        for (int i = 0; i <10 ; i++) {
            int j=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    local.set(j);
                    System.out.println(Thread.currentThread().getName()+"->"+local.get());
                }
            }).start();
        }
        local.set("main thread");
        System.out.println(Thread.currentThread().getName()+"->"+local.get());
       Class clazz=Test.class;
       Object o= clazz.newInstance();
       Constructor c=clazz.getDeclaredConstructor(int.class);
       c.setAccessible(true);
       Object o1=c.newInstance(100);
//        Object o1 = c.newInstance(1000);
       Method method=clazz.getMethod("printMsg",String.class);
       method.invoke(o1,"150");
//       Constructor<?> c=t.getDeclaredConstructor(int.class);
//       c.setAccessible(true);
//       Method Test_method=clazz.getMethod("printMsg",String.class);
//       Test_method.invoke(clazz,"aaaaa",null,false);
    }
}

