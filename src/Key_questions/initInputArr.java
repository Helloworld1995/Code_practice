package Key_questions;

import java.util.Scanner;

public class initInputArr {
    public static int[] initArr(){
        Scanner sc=MyInput.scanf();
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
        }
        return a;
    }
}
