package Key_questions.slidingWindows;

/**
 * 每个小文件编号从0至N-1，相应大小分别记为S(i)。
 * 给定磁盘空间为C，试实现一个函数从N个文件中连
 * 续选出若干个文件拷贝到磁盘中，使得磁盘剩余
 * 空间最小。
 */
public class SubFiles {
    public static void main(String[] args) {
        int[] files={1,2,3,4,14,8,7,8,9,11,10,12,13,15,17,16};
        int minDisk = minDisk(files, 59);
        System.out.println(minDisk);
    }
    public static int minDisk(int[] f,int c){
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int sum=0;
        int left=0;
        int right=0;
        while(i<=j&&j<f.length){
            if(sum<=c){
                int temp=c-sum;
                if(min>temp){
                    min=temp;
                    left=i;
                    right=j-1;
                }
                sum+=f[j++];
            }else{
                sum-=f[i++];
            }
        }
        System.out.printf("从第%d到第%d个文件\n",left,right);
        return min;
    }
}
