package Key_questions;

import java.util.Scanner;

/**
 * 数组中所有元素可以分解为素数之和，问数组中所有元素所分解的最大素数个数
 */
public class ArrNumberSplitPrimes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum=0;
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
            sum+=split(a[i]);
        }
        System.out.println(sum);

    }
    public static int split(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(n%2!=0){
            return n/2;
        }else{
            return (n-3)/2+1;
        }
    }
}
