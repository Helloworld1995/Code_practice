package data_structrue;

/**
 * 不适用比较运算求出两个数的最大最小值
 */
public class FindMaxAndMin {
    public static int max(int a,int b){
        return (a+b+Math.abs(a-b))/2;
    }
    public static int min(int a,int b){
        return ((a+b)-Math.abs(a-b))/2;
    }

    public static void main(String[] args) {
        System.out.printf("the max value is %d \n",max(1024,1023));
        System.out.printf("the min value is %d \n",min(1024,1023));
    }

}
