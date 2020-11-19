package Key_questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到两个数，和正好为S，如若有多对，找到乘积最小的
 */
public class FindSum {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        int[] a={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        int target=14;
        int min=Integer.MAX_VALUE;
        int left=0;
        int right=a.length-1;
        while(left<right){
            int temp=a[left]+a[right];
            if(temp>target){
                right--;
            }else if(temp<target){
                left--;
            }else{
                int k=a[left]*a[right];
                list.add("("+a[left]+","+a[right]+")");
                if(k<min){
                    min=k;
                }
                left++;
                right++;
            }
        }
        System.out.println(min);
        System.out.println(list.toString());
    }
}
