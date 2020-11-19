package Key_questions;

import java.util.Scanner;

/**
 * 输入数字n,按顺序打印出
 */
public class printMaxOfN {
    public static void main(String[] args) {
        printMaxOfN print=new printMaxOfN();
        Scanner sc=new Scanner(System.in);
        char[] number=new char[sc.nextInt()];
        print.print1ToMaxOfN(number,0);
    }
    private void print1ToMaxOfN(char[] number,int digit){
        if(digit==number.length){
            print(number);
            return;
        }
        for (int i = 0; i <10 ; i++) {
            number[digit]=(char)(i+'0');
            print1ToMaxOfN(number,digit+1);
        }
    }
    private void print(char[] c){
        int index=0;
        while(index<c.length){
            if(c[index]=='0') {
                index++;
            }else{
                break;
            }
        }
        while(index<c.length){
            System.out.print(c[index++]);
        }
        System.out.print(" ");
    }
}
