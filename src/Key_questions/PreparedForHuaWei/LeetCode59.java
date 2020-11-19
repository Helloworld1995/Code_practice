package Key_questions.PreparedForHuaWei;

public class LeetCode59 {
    public static void main(String[] args) {
        LeetCode59 leetcode=new LeetCode59();
        int[][] res = leetcode.generateMatrix(3);
        for (int i = 0; i <res.length ; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] generateMatrix(int n) {
        int len=n*n;
        int[][] res=new int[n][n];
        int top=0,left=0,right=n,bottom=n,index=1;
        while(left<right&&top<bottom&&index<=len){
            for(int i=left;i<right;i++){
                res[top][i]=index;
                index++;
            }
            if(top+1<bottom&&index<=len){
                for(int i=top+1;i<bottom;i++){
                    res[i][right-1]=index;
                    index++;
                }
            }
            if(right-1>left&&index<=len){
                for(int i=right-2;i>=left;i--){
                    res[bottom-1][i]=index;
                    index++;
                }
            }
            if((bottom-1>top+1)&&index<=len){
                for(int i=bottom-2;i>=top+1;i--){
                    res[i][left]=index;
                    index++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
