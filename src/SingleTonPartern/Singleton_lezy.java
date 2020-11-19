package SingleTonPartern;

/**
 * 单例模式懒汉式
 */
public class Singleton_lezy {
    private static volatile Singleton_lezy instance=null;
    private Singleton_lezy(){}
    public static Singleton_lezy getInstance(){
        if(instance!=null){
            return instance;
        }
        if(instance==null){
            synchronized (Singleton_lezy.class){
                instance=new Singleton_lezy();
            }
        }
        return instance;
    }
}
