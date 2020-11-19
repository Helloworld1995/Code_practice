package Key_questions.PreparedForHuaWei;

import java.util.Arrays;

/**
 * 垃圾做法
 */
public class LeetCode79 {
    int[] forward1 = {1, 0, -1, 0};
    int[] forward2 = {0, -1, 0, 1};
    int[][] visited = null;
    public boolean exist(char[][] board, String word) {
        int l = board.length;
        int w = board[0].length;
        visited = new int[l][w];
        char[] words = word.toCharArray();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j <w ; j++) {
                visited[i][j]=1;
                if(dfs(board,words,i,j,0)){
                    return true;
                }
                visited[i][j]=0;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,char[] word,int i,int j,int index) {
        if(board[i][j]!=word[index]){
            return false;
        }
        if(index==word.length-1){
            return true;
        }
        for (int k = 0; k <forward1.length ; k++) {
            int newX=i+forward1[k];
            int newY=j+forward2[k];
            if(newX<0||newY<0||newX>board.length-1||newY>board[0].length-1){
                continue;
            }
            if(visited[newX][newY]==0){
                visited[newX][newY]=1;
                boolean res=dfs(board,word,newX,newY,index+1);
                if(res){
                    return true;
                }
                visited[newX][newY]=0;
            }
        }
       return false;
    }
    public static void main(String[] args) {
//        char[][] board ={ {'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        char[][] board ={ {'a'},{'a'}};
        LeetCode79 leetcode = new LeetCode79();
        boolean flag = leetcode.exist(board, "aaa");
        System.out.println(flag);
    }
}
