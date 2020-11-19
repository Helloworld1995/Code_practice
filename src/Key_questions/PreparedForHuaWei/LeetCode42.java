package Key_questions.PreparedForHuaWei;

import java.util.Arrays;

public class LeetCode42 {
    public int getMax(int[] nums){
        int len=nums.length;
        int[] dp=new int[len];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<len;i++){
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }else{
                dp[i]=nums[i];
            }
            max=Math.max(max,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
    public static void main(String[] args) {
        LeetCode42 m=new LeetCode42();
        int[] a={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(m.getMax(a));
    }
}
