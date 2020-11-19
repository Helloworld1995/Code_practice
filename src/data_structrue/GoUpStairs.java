package data_structrue;

public class GoUpStairs {
    /**
     * can just jump 1 or 2 or 3 steps
     * @param n
     * @return
     */
    public static int UpStairs(int n){
        if(n==0||n==1||n==2){
            return n;
        }else if(n==3){
            return 4;
        }else{
            return UpStairs(n-1)+UpStairs(n-2)+UpStairs(n-3);
        }
    }

    /**
     * can just jump 1 or 3 steps
     * @param n
     * @return
     */
    public static int upStairs(int n){
        if(n==0||n==1){
            return n;
        }else if(n==2){
            return 1;
        }else if(n==3){
            return 2;
        }else{
            return upStairs(n-1)+upStairs(n-3);
        }
    }
    public static void main(String[] args) {
        int result=UpStairs(10);
        int result2=upStairs(10);
        System.out.println(result2);
    }
}
