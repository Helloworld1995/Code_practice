package Key_questions.ZTE_bishi;

import java.util.Scanner;

public class ZTE02 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        while(num>0){
            sc.nextLine();
            String s=sc.nextLine();
            int l=sc.nextInt();
            int r=sc.nextInt();
            System.out.println(func(s,l,r));
            num--;
        }
    }
    private static int func(String s, int l, int r){
        char[] cs = s.toCharArray();
        int sum=0;
        for (int i = l; i <=r ; i++) {
            int k=0;
            for (int j = cs.length-1; j>=0; j--) {
                sum+=Math.pow(l,k);
                k++;
            }
        }
        System.out.println(sum);
        if(sum%2==0){
            return 1;
        }else{
            return 0;
        }
    }
}
