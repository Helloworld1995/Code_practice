package Key_questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为S的连续正数序列
 */
public class LianXuHeWeiSdeSubArr {
    static List<ArrayList<Integer>> list=new ArrayList<>();
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,4,3,2,5,3,0};
        func(a,15);
        for (ArrayList<Integer> l : list) {
            System.out.println(l.toString());
        }
    }
    public static void func(int[] a,int target){ //非连续{2,4,1,5,6,……}
        int i=0;
        int j=1;
        while(i<j&&j<a.length){
            int temp=compute(i,j,a);
            if(temp<target){
                j++;
            }else if(temp>target){
                i++;
            }else{
                ArrayList<Integer> l=new ArrayList<>();
                for (int k = i; k <=j ; k++) {
                    l.add(a[k]);
                }
                list.add(l);
                i++;
                j++;
            }
        }
    }
    public static int compute(int i,int j,int[] a){
        int sum=0;
        for (int k = i; k <=j; k++) {
            sum+=a[k];
        }
        return sum;
    }
}
