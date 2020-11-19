package data_structrue.Sorts;

public class MyQuickSort {
    public static void main(String[] args) {
        int[] a={1,3,4,2,7,5,8,1};
        myQuickSort(a,0,a.length-1);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
    public static void myQuickSort(int[] a,int left,int right){
        if(left>=right){
            return;
        }
        int index=a[left];
        int i=left;
        int j=right;
        while(i<j){
            while(i<j&&index<=a[j]){  //一定先从右边哦
                j--;
            }
            while(i<j&&index>=a[i]){
                i++;
            }

            if(i<j) {
                swap(a, i, j);
            }
        }

        a[left]=a[i];
        a[i]=index;
        myQuickSort(a,left,i-1);
        myQuickSort(a,i+1,right);


    }
    public static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
