package Key_questions;

/**
 * 分n元，一次可以分1元,2元....n元。则有多少种分法？
 * 对比青蛙跳，但是青蛙跳少了一个过程，就是肯定能一次跳到终点，对比分钱就是一次分n，故需要在青蛙跳基础上+1
 */
public class Fenqian {
    public static void main(String[] args) {
        long result=fibo(50);
        System.out.println(result);

    }
    public static long fibo(int n){
        if(n<1){
            return -1;
        }
        long[] f=new long[n+1];
        f[1]=1;
        f[2]=2;
        for (int i = 3; i <=n ; i++) {
            int j=1;
            long temp=0;
            while(j<i){
                temp+=f[i-j];
                j++;
            }
            f[i]=temp;
        }
        return f[n];
    }
}
