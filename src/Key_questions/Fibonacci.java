package Key_questions;

/**
 * O(N)求解斐波那契数列
 */
public class Fibonacci {
    public static int fibonacci(int n){
        if(n<=1){
            return n;
        }
        int[] fib=new int[n+1];
        fib[1]=1;
        for (int i = 2; i <=n ; i++) {
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        int result=fibonacci(2020);
        System.out.println(result);
    }
}
