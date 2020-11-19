package Key_questions.ByteJump;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main01 {
    static int count=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int l=sc.nextInt();
        int r=sc.nextInt();
        int[] arr=initArr(n,l,r);
        int[] sub=new int[n];
        int i=0;
        int j=n-1;
        while(j<arr.length){
            int a=i;
            for (int k = 0; k <n ; k++) {
                sub[k]=arr[a];
                a++;
            }
            getAllOrder(sub,0,sub.length-1);
            i++;
            j++;
        }
        for (int k = 0; k <arr.length ; k++) {

        }
        System.out.println(count);
    }
    public static void getAllOrder(int[] array, int begin, int length) {
        if (begin == length - 1) {
            // 每个递归的最后，是打印输出
            System.out.println(Arrays.toString(array));
            count++;
        } else {
            for (int i = begin; i < length; i++) {
                //如果i和前面begin~i-1都没重复，才可以swap
                boolean doubleSign = false;
                for(int j = begin;j<i;j++){
                    if(array[j] == array[i]){
                        doubleSign = true;
                    }
                }
                if(doubleSign){
                    continue;
                }
                // 使用for(int i = begin; i < length; i++)去轮流放在第一位
                swap(array, begin, i);
                // 无视第一位，将后续的元素继续递归
                getAllOrder(array, begin + 1, length);
                // 如果不恢复现场，那么allRank就是一个会改变array的函数，那么
                // 使用“for(int i = begin; i < length; i++)去轮流放在第一位的做法”
                // 就会失效。
                swap(array, i, begin);
            }
        }
    }
    public static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static int[] initArr(int n,int l,int r){
        if(l>=r){
            return null;
        }
        int[] arr=new int[r-l+1];
        int j=0;
        for (int i = l; i <=r ; i++) {
            arr[j]=i;
            j++;
        }
        return arr;
    }
    public static boolean check(int[] a){
        int sum=0;
        for (int i = 0; i <a.length ; i++) {
            sum+=a[i];
        }
        if(sum%3==0){
            return true;
        }
        return false;
    }
}
