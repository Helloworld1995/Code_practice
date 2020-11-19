package Key_questions.PreparedForHuaWei;

import java.util.Arrays;
import java.util.Stack;

/**
 * 最长上升子序列
 */
public class LongestLIS {
    public static void main(String[] args) {
        int[] a={1,3,4,2,3,5,6,7,2,4,1,5,6,0};
        int[] dp=new int[a.length];
        Stack<Integer> stack=new Stack<>();
        Arrays.fill(dp,1);
        int maxlen=-1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <i ; j++) {
                if(a[i]>a[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i]>maxlen){
                maxlen=dp[i];
            }
        }
        System.out.println(maxlen);
        int max=-1;
        int index=-1;
        for (int i = dp.length-1; i >=0 ; i--) {
            if(dp[i]>max){
                max=dp[i];
                index=i;
            }
        }
        int k=a[index];
        stack.push(a[k]);
        for (int i = index; i >=0 ; i--) {
            if(a[i]==k-1){
                k=a[i];
                stack.push(k);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+",");
        }

    }
}
