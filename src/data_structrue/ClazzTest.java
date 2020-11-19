package data_structrue;

public class ClazzTest {
    static String msg="哈哈哈哈";
    static {
        System.out.println("我是普通外部类的一个静态代码块"+msg);
    }
    static class StaticClazz{
        public static void printmsg(){
            System.out.println("我属于静态内部方法");
        }
    }
    public static void main(String[] args) {
        StaticClazz.printmsg();
    }
}
