package LanQiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 质数
 */
public class getZhiShu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
        }
        List<Integer> resultList = getZhishu(a);
        for (Integer i : resultList) {
            System.out.print(i+" ");
        }
    }
    public static List<Integer> getZhishu(int[] a){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <a.length ; i++) {
            boolean flag=true;
            for (int j = 2; j <(int)(Math.sqrt(a[i]))+1 ; j++) {
                if(a[i]%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                list.add(a[i]);
            }
        }
        return list;
    }
}
