package data_structrue;

/**
 * 利用递归实现寻找数组最大元素
 */
public class findMaxInDigui {
    public static void findMax(int[] arr,int index,int tempMax){
        if(index==arr.length-1){
            System.out.println(tempMax);
            return;
        }
       if(tempMax<arr[index]){
            tempMax=arr[index];
        }
        index++;
        findMax(arr,index,tempMax);
    }
    public static int max(int a,int b){
        return a>b?a:b;
    }
    public static  int findMax2(int[] arr,int begin){
        int length= arr.length-begin;
        if(length==1){
            return arr[begin];
        }else{
            return max(arr[begin],findMax2(arr,begin+1));
        }
    }
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,9,10,12,32,0,14};
        findMax(arr, 0, arr[0]);
        int max = findMax2(arr, arr[0]);
        System.out.println(max);
    }
}
