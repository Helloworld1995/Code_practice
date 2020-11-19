package QuestionsForMianshi;

import java.util.Arrays;

/**
 * 二分查找递归实现
 */
public class BinarySearchDigui {
    public static void binarySearch(int low,int high,int[] a,int target){
        int middle=(low+high)/2;//X.5 or X q取整皆为X
        if(target<a[middle]){
            binarySearch(low,middle-1,a,target);
        }else if(target>a[middle]){
            binarySearch(middle+1,high,a,target);
        }else{
            System.out.println(middle);
            return;
        }
    }
    public static void main(String[] args) {
        int[] a={1,4,5,2,7,9,13,22,11};
        int target=22;
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        binarySearch(0,a.length-1,a,target);
    }
}
