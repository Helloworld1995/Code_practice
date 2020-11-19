package data_structrue.Sorts;

import java.util.Arrays;


public class Sorts {
    /**
     * 选择排序
     */
    public static void selectSort(int[] a) {
        int flag = 0;
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            temp = a[i];
            flag = i;
            for (int j = i + 1; j < a.length; j++) {
                if (temp > a[j]) {
                    temp = a[j];
                    flag = j;
                }
            }
            if (flag != i) {
                a[flag] = a[i];
                a[i] = temp;
            }
        }
    }

    /**
     * 插入排序
     * @param a
     */
    public static void insertSort(int[] a){
        if(a==null){
            throw new RuntimeException("数组不能为空！");
        }
        for (int i = 1; i <a.length ; i++) {
            int temp=a[i];
            int j=i;
            if(a[j-1]>temp){
                while(j>=1&&a[j-1]>temp){
                    a[j]=a[j-1];
                    j--;
                }
            }
            a[j]=temp;
        }
    }

    public static void BubbleSort(int[] a){
        if(a==null){
            throw new RuntimeException("数组不能为空！");
        }
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if(a[j]>a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
    }
    public static void BubbleSort2(int[] a){
        if(a==null){
            throw new RuntimeException("数组不能为空！");
        }
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if(a[j]<a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
    }
    public static void quickSort2(int[] a,int left,int right){
         if(left>=right){
             return;
         }
         int key=a[left];
         int i=left;
         int j=right;
         while(i<j){
             while(a[j]>=key&&i<j){
                 j--;
             }
             while(a[i]<=key&&i<j){
                 i++;
             }
             if(i<j) {
                 int temp = a[i];
                 a[i] = a[j];
                 a[j] = temp;
             }
         }
         a[left]=a[i];//将小的放左边
         a[i]=key;  //由于key在左数组内是最大的，故将key放在左数组最右边；
         quickSort2(a,left,i-1);
         quickSort2(a,i+1,right);
    }
    public static void quickSort(int[] a,int low,int high){
        int i,j;
        int index;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        index=a[low];
        while(i<j) {
            while (i < j && a[j] >= index) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            while (i < j && a[i] < index) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i]=index;
        quickSort(a,low,i-1);
        quickSort(a,i+1,high);
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{3,4,3,6,3,2,1,8,7,9,3,6};
//        selectSort(arr);
//        insertSort(arr);
//        BubbleSort2(arr);
        quickSort2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
