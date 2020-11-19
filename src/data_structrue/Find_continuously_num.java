package data_structrue;

/**
 * 判断数组中的数值是否连续相邻，非0数字不能重复
 */
public class Find_continuously_num {
    public static boolean isContinuous(int[] a){
        int max;
        int min=Integer.MAX_VALUE;
        int n=a.length;
        int zero=0;
        max=a[0];
        for (int i = 0; i <a.length ; i++) {
            if (a[i] != 0) {
                if (a[i] > max) {
                    max = a[i];
                }
                if (a[i] < min) {
                    min = a[i];
                }
            }else{
                zero++;
            }
        }
        if(max-min==n-1-zero){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[] a={0,0,4,0,1,3,2};
        boolean flag = isContinuous(a);
        System.out.println(flag);
    }
}
