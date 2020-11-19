package Key_questions.PreparedForHuaWei;

/**
 * 最大连续子数组和（子序列）
 */
public class MaxValueSubLIS {
    public static void main(String[] args) {
        int[] a={1,3,4,2,4,6,8,9,-1,-32,3,4,13,-6,-7};
        int res1 = maxSubSequenceSum1(a);
        int res2 = maxSubSequenceSum2(a);
        System.out.println(res1);
        System.out.println(res2);
    }
    private static int maxSubSequenceSum1(int[] a){
        int maxValue=0;
        for (int i = 0; i <a.length ; i++) {
            int thisSum=0;
            for (int j = i; j <a.length ; j++) {
                thisSum+=a[j];
                if(thisSum>maxValue){
                    maxValue=thisSum;
                }
            }
        }
        return maxValue;
    }
    private static int maxSubSequenceSum2(int[] a){
        int maxValue=0;
        int thisSum=0;
        for (int i = 0; i <a.length ; i++) {
            thisSum+=a[i];
            if(thisSum>maxValue){
                maxValue=thisSum;
            }else if(thisSum<0){
                thisSum=0;
            }
        }
        return maxValue;
    }
}
