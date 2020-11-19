package data_structrue.ArrayPractice;

/**
 * 如何求二进制中1的个数？
 */
public class find_num_of_ones {
    public static int oneCount(int n){
        int onecount=0;
        int zerocount=0;
        int k=0;
        while(n>0){
            if((n&1)==1){
               onecount++;
            }
            n>>=1;
            k++;
        }
        zerocount=k-onecount;
        System.out.printf("0的个数%d \n",zerocount);
        return onecount;
    }
    public static int oneCount2(int n){
        int count=0;
        while(n>0){
            n=n&(n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.printf("1的个数%d\n",oneCount(999999999));
        System.out.printf("1的个数%d\n",oneCount2(7));

    }
}
