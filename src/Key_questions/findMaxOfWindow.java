package Key_questions;

import java.util.Random;
import java.util.Scanner;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 */
public class findMaxOfWindow {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random rand=new Random();
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=rand.nextInt(1000);
        }
        int size=79;
        int i=0;
        int j=i+size-1;
        int value=0;
        while(j<=a.length-1){
            value=findMax(a,i,j);
            System.out.print(value+" ");
            i++;
            j++;
        }
    }
    public static int findMax(int[] a,int i,int j){
        int max=-1;
        for (int k = i; k <=j ; k++) {
            if(max<a[k]){
                max=a[k];
            }
        }
        return max;
    }

}
