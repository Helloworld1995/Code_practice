package Sorts;

import java.util.Random;

/**
 * 我的冒泡排序
 */
public class MyBubbleSort {
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
    public static void sort(int[] a){
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j = 0; j <a.length-i-1 ; j++) {
                if(a[j]>a[j+1]){
                    int temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
    }
}
