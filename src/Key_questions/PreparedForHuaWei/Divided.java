package Key_questions.PreparedForHuaWei;

/**
 * 不使用除法将两数相除
 */
public class Divided {
    public static void main(String[] args) {
        Divided dv=new Divided();
        int res = dv.divide(2147483647, -1);
        System.out.println(res);
    }
    public int divide(int dividend,int divisor){
        if(dividend==0){
            return 0;
        }
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative=(dividend^divisor)<0;
        int result=0;
        long t=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);
        for (int i = 31; i >=0 ; i--) {
            if((t>>i)>=d){
                result+=1<<i;
                t-=d<<i;
            }
        }
        return negative?-result:result;
    }
}
