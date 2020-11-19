package Key_questions.Sorts;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr={4,6,8,5,9};
        for (int i = arr.length/2-1; i >=0 ; i--) {
            ajustHeap(arr,i,arr.length);
        }
        for (int i =arr.length-1; i >0 ; i--) {
            swap(arr,0,i);
            ajustHeap(arr,0,i);
        }
        System.out.println(Arrays.toString(arr));

    }
    private static void ajustHeap(int[] arr,int i,int len){
        int temp=arr[i];
        for (int k = 2*i+1; k >=0 ; k--) {
            if(k+1<len&&arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else{
                break;
            }
        }
        arr[i]=temp;
    }
    private static void swap(int[] arr,int i,int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
}
