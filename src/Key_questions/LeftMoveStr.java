package Key_questions;

import java.util.Scanner;

/**
 * 左移字符串
 */
public class LeftMoveStr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int k=sc.nextInt();
        int n=s.length();
        char[] chars = s.toCharArray();
        reverse(chars,0,k-1);
        reverse(chars,k,n-1);
        reverse(chars,0,n-1);
        System.out.println(new String(chars));
    }
    private static void reverse(char[] c,int i,int j){
        while(i<j){
            char t=c[j];
            c[j]=c[i];
            c[i]=t;
            i++;
            j--;
        }

    }
}
