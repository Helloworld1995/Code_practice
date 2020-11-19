package Key_questions;


import java.util.Scanner;

/**
 * 可以删除一个字符，判断是否能构成回文字符串。
 */
public class CheckIfHuiWen {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                boolean b1=keepCheck(s,i+1,j);
                boolean b2=keepCheck(s,i,j-1);
                if(b1||b2){
                    System.out.println(true);
                    break;
                }
            }
            i++;
            j--;
        }
        System.out.println(true);
    }
    public static boolean keepCheck(String s,int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
