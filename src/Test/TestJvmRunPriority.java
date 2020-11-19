package Test;

import com.sun.media.jfxmedia.logging.Logger;

/**
 * 类加载顺序
 */
public class TestJvmRunPriority {


    int init=1;
    {
        System.out.println(init);
        System.out.println("这是父类的块。。。");
    }
    static{

        System.out.println("这是父类的静态块。。。");
    }

    TestJvmRunPriority(){

        System.out.println("这是父类的构造函数。。。");
    }
    public static void main(String[] args) {
        TestJvmRunPriority t=new Sub();
    }
}
class Sub extends TestJvmRunPriority{
    {
        System.out.println("这是子类的块。。。");
    }
    static {
        System.out.println("这是子类的静态块。。。");
    }
    Sub(){
        super();
        System.out.println("这是子类的构造函数");
    }
}
