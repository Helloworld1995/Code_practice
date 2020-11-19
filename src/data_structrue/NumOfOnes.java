package data_structrue;

import java.util.Scanner;

public class NumOfOnes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=feibonaqi2(n);
        System.out.println(m);
    }
    public static int  feibonaqi2(int n){
        int count=2;
       int temp1=1;
       int temp2=1;
       int third=1;
        for (int i = 3 ;i <= n; i++) {
            temp1=temp2;
            temp2=third;
            third=temp1+temp2;
            if(String.valueOf(third).contains("1")){
                count++;
            }
        }
        return count;
    }
    public static int feibonaqi(int n){
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
           return 1;
        }
        return feibonaqi(n-1)+feibonaqi(n-2);
    }
}
