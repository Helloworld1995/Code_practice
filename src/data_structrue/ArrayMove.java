package data_structrue;

import java.util.Arrays;

/**
 * 如何将数组右移2位。12345678>>2=78123456
 * 先将123456逆序=65432178
 * 将78逆序=65432187
 * 将65432187逆序=78123456
 */
public class ArrayMove {
    public static void reverse(int[] a,int b,int e){ //***对调数据算法！
        while(b<e){
            int temp=a[b];
            a[b]=a[e];
            a[e]=temp;
            b++;
            e--;
        }
    }
    public static void shift(int[] a,int k){
        int n=a.length-1;
        k=k%n;//当位移位数大于数组长度，相当于位移取余次
        reverse(a,0,n-k);
        reverse(a,n-k+1,n);
        reverse(a,0,n);
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9};
        int move=5;
        shift(a,move);
        System.out.println(Arrays.toString(a));
    }
}
