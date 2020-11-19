package Key_questions.LIS_questionsPkt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 最长上升子序列
 */
public class LongsetLIS {
    public static void main(String[] args) {
        int[] a={10,9,2,5,3,7,101,18};
        List<Integer> res=new ArrayList<>();
        int[] dp=new int[a.length];
        Arrays.fill(dp,1);//当前位开始的子序列，默认长度1
        int maxValue=0;
        int startIndex=-1;
        for (int i = 1; i <a.length ; i++) {
            int cur=a[i];
            int max=1;
            for (int j = 0; j <i ; j++) {//以当前元素结尾的最长上升子序列等于以比这个元素小的元素为结尾的上升子序列长度+1，然后比较获得最大的值。
                if(cur>a[j]) {
                    max = Math.max(max, dp[j]+1);
                }
            }
            dp[i]=max;
            maxValue=Math.max(maxValue,dp[i]);
//            if(maxValue<dp[i]){
//                maxValue=dp[i];
//                startIndex=i;
//            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(maxValue);
        int j=startIndex;
        res.add(a[startIndex]);
        j--;
        if(j<0){
            return;
        }
        while(j>=0){
            if(dp[j]==dp[startIndex]-1){
                res.add(a[j]);
            }
            startIndex=j;
            j--;
        }
        Collections.reverse(res);
        System.out.println(res.toString());
    }
}
