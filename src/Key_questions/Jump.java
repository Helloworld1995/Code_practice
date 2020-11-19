package Key_questions;

/**
 * 变态青蛙跳，青蛙可一次跳1阶台阶，2，3，……n阶台阶;
 */
public class Jump {
    public static void main(String[] args) {
        int result=jump(30);
        System.out.println(result);
        int result2=jump2(30);
        System.out.println(result2);
    }
    public static int jump(int n){
        if(n==1){
            return 1;
        }
        return 2*jump(n-1);
    }

    /**
     * 能跳1阶，2阶，3阶，利用动态规划
     * 动态规划转移公式 f(n)=f(n-1)+f(n-2)+f(n-3)
     * @param s
     * @return
     */
    public static int jump2(int s){
        int[] result=new int[s+1];
        result[1]=1;
        result[2]=2;
        result[3]=4;
        for (int i = 3; i <s+1 ; i++) {
            result[i]=result[i-1]+result[i-2]+result[i-3];
        }
        return result[s];
    }
}
