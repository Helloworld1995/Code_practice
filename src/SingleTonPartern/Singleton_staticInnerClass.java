package SingleTonPartern;

/**
 * 饿汉式：静态内部类实现
 */
public class Singleton_staticInnerClass {
    private static class Singleton{
        private static final Singleton_staticInnerClass INSTANCE=new Singleton_staticInnerClass();
    }
    private Singleton_staticInnerClass(){}
    public static Singleton_staticInnerClass getInstance(){
        return Singleton.INSTANCE;
    }
}
