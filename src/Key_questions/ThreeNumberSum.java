package Key_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args) {
        ThreeNumberSum t=new ThreeNumberSum();
        int[] a={-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = t.threeSum(a);
        for (List<Integer> re : res) {
            System.out.println(re.toString());
        }
    }

    /**
     * [-2,-2,0,1,2,3,4] 由于nums[0]==nums[1]=-2,指针在nums[0]的时候，其搜索空间为[-2,0,1,2,3,4]：
     * 1.倘若[-2,-2,4]为其中一个可能，由于不能重复，所以只有这一种可能；
     * 2.倘若[-2,0,2]为其中一种可能，由于不能重复，当指针指到nums[1]时依然是-2，则后续的可能性已经被前一个-2搜索过了，因为
     * 不能重复，所以无需再搜索，直接跳到下一个非-2的元素。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target=0;
        int temp;
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                temp=nums[i]+nums[left];
                if(temp<-nums[right]){
                    left++;
                }else if(temp>target){
                    right--;
                }else{
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    res.add(l);
                    left++;
                    right--;
                    while(left<right&&nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right&&right<nums.length-1&&nums[right]==nums[right+1]){
                        right--;
                    }
                }
            }
        }
        return res;
    }

}
