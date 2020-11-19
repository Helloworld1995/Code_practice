package Test;

public class Test_Return_Finally {
    public static void main(String[] args) {
        int i = test();
        System.out.println(i);
    }
    private static int  test(){
        int i=1;
        try{
            int k=i/0;
            return i;
        }catch (Exception e){
            e.printStackTrace();
            return ++i;
        }finally {
            System.out.println("finally...."+i);
            return ++i;
        }
    }
}
