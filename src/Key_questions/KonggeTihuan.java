package Key_questions;

import java.util.Scanner;

/**
 * 将字符串中的空格替换成其他字符串or字符
 */
public class KonggeTihuan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String c=sc.nextLine();
        String result=replace(s,c);
        System.out.println(result);

    }
    public static String replace(String s,String c){
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)==' '){
                sb.insert(i,c);
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
