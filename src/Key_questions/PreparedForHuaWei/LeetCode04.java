package Key_questions.PreparedForHuaWei;

public class LeetCode04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m=0;
        int n=matrix[0].length;
        int row=m,col=n-1;
        while(row<m&&col>=0){
            if(matrix[row][col]>target){
                col--;
            }else if(matrix[row][col]<target){
                row++;
            }else{
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m={{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        LeetCode04 leetCode04=new LeetCode04();
        System.out.println(leetCode04.findNumberIn2DArray(m, 20));
    }
}
