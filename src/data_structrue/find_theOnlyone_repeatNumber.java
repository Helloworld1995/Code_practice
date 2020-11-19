package data_structrue;

/**
 * 数字1~N-1存放在长度为N的数组中，其中有唯一一个重复数，找出它
 */
public class find_theOnlyone_repeatNumber {
    public static int find(int[] a){
        int sumAll=0;
        int sum=0;
        for (int i = 0; i <a.length-1 ; i++) {
            sumAll+=a[i];
            sum+=(i+1);
        }
        sumAll+=a[a.length-1];
        return sumAll-sum;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9,9};
        System.out.println(find(a));
    }
}
