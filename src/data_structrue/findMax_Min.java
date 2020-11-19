package data_structrue;

public class findMax_Min {
    public static int[] getMax_Min(int[] arr){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int[] result=new int[2];
        for (int i = 0; i <arr.length ; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
            if(min>arr[i]){
                min=arr[i];
            }
        }
        result[0]=max;
        result[1]=min;
        return result;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,89,10086};
        int[] max_min = getMax_Min(arr);
        System.out.printf("the max value is %d \n the min value is %d",max_min[0],max_min[1]);
    }
}
