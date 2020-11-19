package Test;

public class TryCatchFinallyReture {

    public static String test() {
       int i=10;
        try{
            int m=i/0;
            return "返回try中的return";
        }catch (Exception e){
            return "catch中的return";
        }finally {
            return "返回finally中的return";
        }
    }

    public static void main(String[] args) {
        String result = test();
        System.out.println(result);
    }
}
