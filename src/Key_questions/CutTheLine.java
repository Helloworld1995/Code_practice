package Key_questions;

/**
 * 剪绳子问题，将长度为n的绳子剪成m段，每段必须是整数。则如何剪使得每段乘积最大?
 * 动态规划：即当我们剪第一次时，可能减去的为1，2，…………，n-1。故递推公式:f(n)=max{f(n-i)*f(i)}
 */
public class CutTheLine {
    public static void main(String[] args) {
        int max=cut(36);
        System.out.println(max);
    }
    public static int cut(int len){
        if(len<2){
            return 0;
        }
        if(len==2){
            return 1;
        }
        if(len==3){
            return 2;
        }
        int[] a=new int[len+1];
        a[0]=0;
        a[1]=1;
        a[2]=2;
        a[3]=3;
        int temp=1;
        for (int i = 4; i <=len ; i++) {
            int max=0;
            for (int j = 1; j <=i/2 ; j++) {
                temp=a[i-j]*a[j];
                if(max<temp){
                    max=temp;
                }
            }
           a[i]=max;
        }
        return a[len];
    }
}
