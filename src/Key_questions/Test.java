package Key_questions;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        new A();
        new A();
    }
}
class A{
    static{
        System.out.println("静态代码块");
    }
    {
        System.out.println("代码段");
    }
    public A(){

        System.out.println("构造方法");
    }
}

