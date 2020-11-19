package Sorts;

import java.util.Random;

/**
 * 我的选择排序
 */
public class MySelectSort {
    public static void sort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            int temp=i;
            int min=arr[i];
            for (int k = i+1; k < arr.length; k++) {
                if(arr[k]<min){
                    min=arr[k];
                    temp=k;
                }
            }
            if(temp!=i) {
                int m = arr[temp];
                arr[temp] = arr[i];
                arr[i] = m;
            }
        }
    }
    public static void main(String[] args) {
        int[] a=new int[100000];
        Random rand=new Random();
        for (int i = 0; i < a.length; i++) {
            a[i]=(int)(rand.nextInt(100));
        }
        long start=System.currentTimeMillis();
        sort(a);
        long end=System.currentTimeMillis();
        System.out.println("耗时:"+(end-start)/1000+"秒");
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}
