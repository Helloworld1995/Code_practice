package Key_questions.IsLandsQuestionsPkt;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS求岛屿数量
 */
public class IsLandBfs {
    static final int X = 5;
    static final int Y = 5;
    static final int[] xs = {1, 0, -1, 0};
    static final int[] ys = {0, 1, 0, -1};
    static Queue<Index> queue=new LinkedList<>();

    public static void main(String[] args) {
        int[][] sea = {{1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0,0, 0, 1, 1},
                {0, 1, 0, 1, 0}};
        int count=0;

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (sea[i][j] == 1) {
                    count++;
                    sea[i][j]=0;
                    BfsSearch(sea, i, j);

                }
            }
        }
        System.out.println(count);
    }
    private static void BfsSearch(int[][] sea,int i,int j){
        queue.add(new Index(i,j,sea[i][j]));
        while(!queue.isEmpty()){
            Index index = queue.poll();
            for (int k = 0; k <xs.length ; k++) {
                int newX=index.x+xs[k];
                int newY=index.y+ys[k];
                if(newX>=0&&newX<X&&newY>=0&&newY<Y&&sea[newX][newY]==1) {
                    sea[newX][newY]=0;
                    queue.add(new Index(newX,newY,sea[newX][newY]));
                    }
                }
            }
        }
}
class Index {
    int x;
    int y;
    int value;

    public Index(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
