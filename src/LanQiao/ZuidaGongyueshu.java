package LanQiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 多个数的最大公约数
 */
public class ZuidaGongyueshu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
        }
        int result=getMaxDiv(a);// 获取最大公约数
        System.out.printf("最大公约数:%d",result);
        System.out.println();
        int result2=getMinDiv(a);//获取最小公倍数
        System.out.printf("最小公倍数:%d",result2);
    }
    public static int getMaxDiv(int[] a){
        int n=a.length;
        int count=0;
        if(n<=2){
            return getMaxDivOf2num(a[0],a[1]);
        }
        for (int i = 2; i < n; i++) {
            count = getMaxDivOf2num(getMaxDivOf2num(a[i-2], a[i - 1]), a[i]);
        }
        return count;
    }
    public static int getMaxDivOf2num(int a,int b){
        while(b!=0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    /**
     * 求最小公倍数:个数的最小公倍数=最大的两个数的最小公倍数：知道最小公约数的话，则最大的两个数乘积/最小公约数=最小公倍数
     */
    public static int getMinDiv(int[] a){
        int sum=1;
        for (int i : a) {
            sum*=i;
        }
        int maxDiv=getMaxDiv(a);
        Arrays.sort(a);
        int a1=a[a.length-2];
        int a2=a[a.length-1];
        return a1*a2/maxDiv;
    }

}
