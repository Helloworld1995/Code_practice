package Key_questions.PreparedForHuaWei;

import java.util.Scanner;

public class PDD {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] price=new int[n];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp=sc.nextInt();
            price[i]=temp;
            if(temp>max){
                max=temp;
            }
            if(temp<min){
                min=temp;
            }
        }
        int t1=max-m;
        int t2=min+m;
        if(t2>=t1){
            System.out.println(t1);
            System.out.println(t2);
        }else{
            System.out.println(-1);
        }

    }
}
