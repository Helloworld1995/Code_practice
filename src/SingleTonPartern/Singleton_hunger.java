package SingleTonPartern;

/**
 * 饿汉式
 */
public class Singleton_hunger {
    private static final Singleton_hunger instance=new Singleton_hunger();
    private Singleton_hunger(){}
    public static Singleton_hunger getInstance(){
        return instance;
    }
}
