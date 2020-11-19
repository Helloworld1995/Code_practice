package Key_questions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 找出数组中所有重复的数字O(N)
 */
public class FindRepeatedNumberOfArr {
    public static void main(String[] args) {
        int[] a = initInputArr.initArr();
        System.out.println(Arrays.toString(a));
        for (int i = 0; i <a.length ; i++) {
            a[a[i]]=a[i];
        }
        System.out.println(Arrays.toString(a));
    }
}
