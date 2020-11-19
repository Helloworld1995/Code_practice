package Key_questions.slidingWindows;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到数组中和为K的最大长子数组
 */
public class MaxSubArr {
    public static void main(String[] args) {
        int[] a=new int[100];
        for (int i = 0; i <a.length ; i++) {
            a[i]= (int) (Math.random()*10);
        }
        int result=maxSubArr(a,36);
        int result1=maxSubArr2(a,36);
        System.out.println(result);
        System.out.println(result1);
    }
    /**
     * 借助HashMap
     * @param a
     * @param k
     * @return
     */
    public static int maxSubArr(int[] a,int k){
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <a.length ; i++) {
            sum+=a[i];
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            if(map.containsKey(sum-k)){
                int temp=i-map.get(sum-k);
                if(temp>max){
                    max=temp;
                }
            }
        }
        return max;
    }

    /**
     * 滑动窗口，注意：数组中皆为正数
     * @param a
     * @param k
     * @return
     */
    public static int maxSubArr2(int[] a,int k){
        int i=0;
        int j=0;
        int max=-1;
        int temp=0;
        while(j<a.length&&i<=j){
            if(temp==k){
                int len=j-i;
                if(max<len){
                    max=len;
                }
                temp-=a[i];
                i++;
            }else if(temp>k){
                temp-=a[i++];
                if(i>j){
                    j++;
                }
            }else{
                temp+=a[j];
                j++;
            }
        }
        return max;
    }
}
