package QuestionsForMianshi;

/**
 * 合并两个数组，一个数组足够大可以放置下两个数组
 */
public class merge2SortArr2 {
    public static void main(String[] args) {
        int[] big={1,4,5,7,10,0,0,0,0};
        int[] small={3,6,9,13};
        merge02(big,small);
        for (int i : big) {
            System.out.print(i+" ");
        }
    }
    public static void merge(int[] big,int[] small){
        int b=4;
        int s=small.length-1;
        int m=s+b+1;
        while(b>=0&&s>=0){
            if(big[b]>small[s]){
                big[m]=big[b];
                m--;
                b--;
            }else{
                big[m]=small[s];
                m--;
                s--;
            }
        }
        while(s>=0){
          big[m--]=small[s--];
        }
    }
    public static void merge02(int[] big,int[] small){
        int s=small.length-1;
        int b=4;
        int m=s+b+1;
        while(b>=0&&s>=0){
            big[m--]=big[b]>small[s]?big[b--]:small[s--];
        }
    }
}
