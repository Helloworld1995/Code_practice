package Key_questions.Sorts;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a={7,6,7,11,5,12,3,0,1};
        int[] temp=new int[a.length];
        mergeSort(a,0,a.length-1,temp);
        System.out.println(Arrays.toString(a));

    }
    private static void mergeSort(int[] a,int start,int end,int[] temp){
        if(start<end){
            int mid=(start+end)/2;
            mergeSort(a,start,mid,temp);
            mergeSort(a,mid+1,end,temp);
            merge(a,start,mid,end,temp);
        }
    }
    private static void merge(int[] a,int start,int mid,int end,int[] temp){

        int p1=start;
        int p2=mid+1;
        int i=0;
        while(p1<=mid&&p2<=end){
            if(a[p1]<a[p2]){
                temp[i++]=a[p1++];
            }else{
                temp[i++]=a[p2++];
            }
        }
        while(p1<=mid){
            temp[i++]=a[p1++];
        }
        while(p2<=end){
            temp[i++]=a[p2++];
        }
        int k=start;
        for (int j = 0; j <i ; j++) {
            a[k++] = temp[j];
        }
    }
}
