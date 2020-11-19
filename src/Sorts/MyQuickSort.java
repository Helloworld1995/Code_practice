package Sorts;

import java.util.Random;

public class MyQuickSort {
    public static void main(String[] args) {
        int[] a=new int[5000];
        Random rand=new Random();
        for (int i = 0; i < a.length; i++) {
            a[i]=(int)(rand.nextInt(100));
        }
        int[] a1={1,3,6,5,7,3};
        long start=System.currentTimeMillis();
        sort(a1,0,a1.length-1);
        long end=System.currentTimeMillis();
        System.out.println("耗时:"+(end-start)+"秒");
        for (int i : a1) {
            System.out.print(i+" ");
        }
    }
    public static void sort(int[] a,int left,int right){
        if(left>=right){
            return;
        }
        int l=left;
        int r=right;
        //中轴值，也可以用第一个值
        int privot=a[left];
        while(l<r){
            while(a[r]>=privot&&l<r){
                r--;
            }
            while(a[l]<=privot&&l<r){
                l++;
            }
            if(l<r) {
                swap(l, r, a);
            }
        }
        a[left]=a[l];
        a[l]=privot;
        sort(a,left,l-1);
        sort(a,l+1,right);
    }
    public static void swap(int i,int j,int[] a){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
