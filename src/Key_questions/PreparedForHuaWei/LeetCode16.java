package Key_questions.PreparedForHuaWei;

public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        int sum=0;
        int v=0;
        int res=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    sum=nums[i]+nums[j]+nums[k];
                    if(sum!=target){
                        v=Math.abs(sum-target);
                        if(v<min){
                            min=v;
                            res=sum;
                        }
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a={0,1,2};
       LeetCode16 l16=new LeetCode16();
        System.out.println(l16.threeSumClosest(a, 3));
    }
}
