package Key_questions;

import java.util.Scanner;

/**
 * 每三年生一只
 */
public class BirthPigs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        int[] pigs=new int[i+1];
        pigs[1]=1;
        pigs[2]=1;
        for (int j = 3; j < pigs.length ; j++) {
            pigs[j]=pigs[j-1]+pigs[j-2];
        }
        System.out.println(pigs[pigs.length-1]);
    }
}
