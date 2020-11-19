package Key_questions.PreparedForHuaWei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和为target的最长连续正整数序列
 */
public class SubStrSumIsTarget {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,6,1,8,3,6,4,5};
        List<int[]> res=new ArrayList<>();
        int target=9;
        int i=0;
        int j=1;
        int temp=0;
        temp+=a[i];
        while(i<j&&j<a.length){
            if(temp>target){
                temp-=a[i++];
            }else if(temp==target){
                int[] arr=new int[j-i];
                int index=0;
                for (int k = i; k < j; k++) {
                    arr[index]=a[k];
                    index++;
                }
                res.add(arr);
                temp-=a[i++];
                temp+=a[j++];
            }else if(temp<target) {
                temp += a[j++];
            }
        }
        if(temp==target){
            int[] arr=new int[j-i];
            int index=0;
            for (int k = i; k < j; k++) {
                arr[index]=a[k];
                index++;
            }
            res.add(arr);
        }
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}
