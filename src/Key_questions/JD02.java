package Key_questions;

import java.util.Scanner;

public class JD02 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt()*100;
        double temp=0;
        int k=1;
        while(m>=0){
            m-=n;
            for (int i = 0; i <k ; i++) {
                temp+=(n/Math.pow(2,k+1));
            }
            m+=temp;
            temp=0.0;
            k++;
        }
        System.out.println(k-1);

    }
}
