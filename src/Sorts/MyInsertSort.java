package Sorts;

import java.util.Random;

/**
 * 我的插入排序，从后面的无序子序列依次把数  “插！！！”  到前面的有序子数组
 */
public class MyInsertSort {
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
            int insert=a[i+1];
            int j=i;
            while(j>=0&&insert<a[j]){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=insert;
        }
    }
}
