package LanQiao;

import java.util.Scanner;

/**
 * 计算最长回文
 */
public class getLongestHuiWen {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String result = getlongetHuiwen(s);
        System.out.println("最长回文串："+result);
    }
    public static String getlongetHuiwen(String s){
        char[] cs = s.toCharArray();
        int count=0;
        int max=-1;
        String subString="";
        for (int i = 1; i <cs.length-1 ; i++) {
            count=0;
            int j=i-1;
            int k=i+1;
            while(j>=1&&j<=i&&k>=i&&k<cs.length-1&&cs[j]==cs[k]){
                j--;
                k++;
                count++;
            }
            count=count*2+1;
            if(count>max){
                max=count;
                subString=s.substring(j,k+1);
            }
        }
        if(max>1) {
            System.out.println("最长回文串长度：" + max);
            return subString;
        }
        return "None";
    }
}
