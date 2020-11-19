package GC.Method_filed;

public class StringTest {
    public static void main(String[] args) {
        String s1="哈哈哈哈哈"; //放入常量池
        String s2=new String("哈哈哈哈哈");//放入堆中
        System.out.println(s1==s2);
    }
}
