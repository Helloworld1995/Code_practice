package data_structrue;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {
    public int binarySearch(int target,int[] a){
        int low=0;
        int len=a.length-1;
        int high=len;
        int middle=0;
        while(low<=high){
            middle=(low+high)/2;
            if(target==a[middle]){
                return middle;
            }else if(target>a[middle]){
                low=middle+1;
            }else{
                high=middle-1;
            }
        }
        throw new RuntimeException("no target value found!");
    }
    public int binarySearchDigui(int low,int high,int target,int[] a){
        if(low<=high){
            int middle=(low+high)/2;
            if(target==a[middle]){
                return middle;
            }else if(target>a[middle]){
                low=middle+1;
                return binarySearchDigui(low,high,target,a);
            }else{
                high=middle-1;
                return binarySearchDigui(low,high,target,a);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5,6,7,9,10,12,32,0,14};
        Arrays.sort(a);
        BinarySearch bs=new BinarySearch();
        int index = bs.binarySearch(12, a);
        int i = bs.binarySearchDigui(0, a.length - 1, 4, a);
        System.out.printf("the target value is a[%s]",i);

    }
}
