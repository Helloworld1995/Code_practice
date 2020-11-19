package data_structrue.Bit_solve;

/**
 * 位操作
 */
public class Bit_solve {
    /**
     * 判断一个数是否是2的n次方,2^1 = 2<<1
     * @param n
     */
    public static boolean isPower(int n){
        int temp=2;
        if(n<2){
            return false;
        }
        if(n%2!=0){
            return false;
        }
        while(temp<=n){
            if(temp==n){
                return true;
            }
            temp=temp<<1;
        }
        return false;
    }
    public static boolean isPower2(int n){
        if(n<2){
            return false;
        }
        int m=n&(n-1);
        return m==0;
    }
    public static void main(String[] args) {
        boolean flag=isPower(1025);
        System.out.println(flag);
    }
}
