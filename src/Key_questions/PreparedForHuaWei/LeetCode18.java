package Key_questions.PreparedForHuaWei;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res=new ArrayList<>();
            Arrays.sort(nums);
            int len=nums.length;
            int sum=0;
            int left=0,right=len-1;
            for(int i=0;i<len-3;i++){
                if(i>0&&nums[i]==nums[i-1]){
                    continue;
                }
                if(nums[i]+nums[len-1]+nums[len-2]+nums[len-3]<target){
                    continue;
                }
                if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                    break;
                }
                sum=target-nums[i];
                for(int j=i+1;j<len-2;j++){
                    if(j>i+1&&nums[j]==nums[j-1]){
                        continue;
                    }
                    if(nums[j]+nums[len-1]+nums[len-2]<sum){
                        continue;
                    }
                    if(nums[j]+nums[j+1]+nums[j+2]>sum){
                        break;
                    }
                    int sum1=sum-nums[j];
                    left=j+1;
                    right=len-1;
                    while(left<right){
                        int sum2=sum1-nums[right]-nums[left];
                        if(sum2==0){
                            if(j==2){
                                System.out.println();
                            }
                            List<Integer> list=new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[left]);
                            list.add(nums[right]);
                            res.add(list);
                            while(left<right&&nums[left]==nums[left+1]){
                                left++;
                            }
                            if(left<right) {
                                left++;
                            }
                            while(left<right&&nums[right]==nums[right-1]){
                                right--;
                            }
                            if(left<right) {
                                right--;
                            }

                        }else if(sum2>0){

                            if(left<right){
                                left++;
                            }
                        }else{

                            if(left<right){
                                right--;
                            }
                        }
                    }
                }
            }
        return res;
    }
    public static void main(String[] args) {
        int[] nums={-2,-1,0,0,1,2};
        LeetCode18 lc18=new LeetCode18();
        List<List<Integer>> res = lc18.fourSum(nums, 0);
        for (List<Integer> re : res) {
            System.out.println(re.toString());
        }
    }
}
