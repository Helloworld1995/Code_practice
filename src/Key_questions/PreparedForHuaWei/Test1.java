package Key_questions.PreparedForHuaWei;

public class Test1 {
    static int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] map= new int[5][4];
    static int[][] visited= new int[5][4];
    static int n=5;
    static int m=4;
    static int ex=4;
    static int ey=0;
    static int count=0;
    public static void main(String[] args) {
        int startX=0;
        int startY=3;
        dfs(startX,startY);
        System.out.println(count);
    }
    private static void dfs(int x, int y) {
        // TODO Auto-generated method stub
        if((x==ex)&&(y==ey)) {
            count++;
            return;
        }
        for(int i=0;i<4;i++) {
            int x1 =x +pos[i][0];
            int y1 = y +pos[i][1];
            if(x1==2&&y1==2){
                continue;
            }
            if(x1>=0&&y1>=0&&x1<n&&y1<m&&(visited[x1][y1]==0)) {
                visited[x1][y1] = 1;
                dfs(x1,y1);
                visited[x1][y1] = 0;
            }
        }
    }
}


