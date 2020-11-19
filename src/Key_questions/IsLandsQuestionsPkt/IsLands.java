package Key_questions.IsLandsQuestionsPkt;

/**
 * 岛屿的数量问题
 */
public class IsLands {
    static int[] xdirection={1,0,-1,0};
    static int[] ydirection={0,1,0,-1};
    public static void main(String[] args) {
        int[][] a={{1,1,1,1,0},
                   {1,1,0,1,0},
                   {1,1,0,0,0},
                   {1,1,0,0,0},
                   {0,0,0,0,0}};
        int size=0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j]==1){
                    size++;
                   deepSearch(a,i,j);
                }
            }
        }
        System.out.println(size);
    }
    private static void deepSearch(int[][] a,int i,int j){
        for (int k = 0; k <xdirection.length ; k++) {
            int newX=i+xdirection[k];
            int newY=j+ydirection[k];
            if(newX>=0&&newX<a.length&&newY>=0&&newY<a[0].length&&a[newX][newY]==1){
                a[newX][newY]=0;
                deepSearch(a,newX,newY);
            }
        }
    }
}
