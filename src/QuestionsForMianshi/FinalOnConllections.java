package QuestionsForMianshi;

import java.util.HashMap;
import java.util.Map;

public class FinalOnConllections {
    public static final HashMap<Integer, String> map = new HashMap<>();
    int index;
    String index2;
    public FinalOnConllections(){

    }
    private FinalOnConllections(int index,String index2){

        this.index=index;
        this.index2=index2;
    }
    private void method(){
        System.out.println(index+index2);
    }
    private void method(String index2,int index){
        System.out.println(index2+index);
    }
//    private int method(String index2,int index){ //方法重载与返回值无关
//        return 10086;
//    }

    public static void main(String[] args) {
        map.put(1, "hehe");
        map.put(2, "haha");
        map.put(3, "wawa");
//        map=new HashMap<>();//final修饰map，其他的都没影响，但是重新new会有影响
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

}
class Child extends FinalOnConllections{
    private Child(){
        super();

    }
    private void method(){
        System.out.println("this is child method()");
    }

    public static void main(String[] args) {
        FinalOnConllections fc=new Child();
        ((Child) fc).method();
    }
}
