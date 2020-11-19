package LanQiao;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组，求反序对的个数
 */
public class ReverseNumbers {
    public static void main(String[] args) {
        int[] a={1,5,3,2,6};
        List<String> list=new ArrayList<String>();
        int count=0;
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j = i+1; j <a.length ; j++) {
                if(a[j]<a[i]){
                    count++;
                    list.add("["+String.valueOf(a[i])+","+String.valueOf(a[j])+"]");
                }
            }
        }
        System.out.println(count);
        for (String s : list) {
            System.out.print(s);
        }
    }
}
