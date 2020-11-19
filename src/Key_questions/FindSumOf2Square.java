package Key_questions;

import java.util.Scanner;

/**
 * 两数平方和
 */
public class FindSumOf2Square {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 3; i <n ; i++) {
            boolean b = check(i);
            if(b){
                System.out.println(i);
            }
        }
    }
    public static boolean check(int n){
        boolean result=false;
        int i=1;
        int j=(int)Math.pow(n,0.5)+1;
        while(i<j){
            if(i*i+j*j<n){
                i++;
            }else if(i*i+j*j>n){
                j--;
            }else{
                result=true;
                System.out.println(i+","+j);
                return result;
            }
        }
        return result;
    }
}
