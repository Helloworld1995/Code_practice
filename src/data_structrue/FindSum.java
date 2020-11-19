package data_structrue;

import java.util.Arrays;

public class FindSum {
    public static void findSum(int[] a){
        Arrays.sort(a);
        int begin=0;
        int end=a.length-1;
        while(begin<end){
            if(a[begin]+a[end]<20){
                begin++;
            }else if(a[begin]+a[end]>20){
                end--;
            }
            else{
                System.out.printf("%d + %d =20 \n",a[begin],a[end]);
                begin++;
                end--;
            }
        }
    }
    public static void findSum2(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j <a.length ; j++) {
                if(a[i]+a[j]==20){
                    System.out.printf("%d + %d =20 \n",a[i],a[j]);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a={1,22,4,5,6,7,23,42,5,6,7,8,4,12,44,55};
        findSum(a);
        findSum2(a);
    }
}
