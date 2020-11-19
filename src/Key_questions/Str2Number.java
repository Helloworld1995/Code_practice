package Key_questions;

import java.util.Scanner;
/**
 * 字符串转化为数字。不能用库函数
 */
public class Str2Number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(transfer(s));
    }
    public static int transfer(String s){
        int temp=0;
        boolean flag=false;
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            if(chars[0]=='+'){
                flag=true;
            }
            if(i>0) {
                if (chars[i] < '0' || chars[i] > '9') {
                    return 0;
                }
                temp = temp * 10 + (chars[i] - '0');
            }
        }
        if(!flag){
            temp=0-temp;
        }
        return temp;
    }
}
