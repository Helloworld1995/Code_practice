package Key_questions;

import java.util.Scanner;

/**
 * 统计整数n的二进制中1的个数
 */
public class NumberOfOne {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int num=numberOfones(n);
        System.out.println(num);
        num=numberOfones02(n);
        System.out.println(num);
    }
    public static int numberOfones(int n){
        int count=0;
        while(n>0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
    public static int numberOfones02(int n){
        int count=0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}
