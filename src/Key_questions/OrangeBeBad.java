package Key_questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 橘子腐烂问题
 */
public class OrangeBeBad {
    static final int X=5;
    static final int Y=5;
    static final int[] xs={1,0,-1,0};
    static final int[] ys={0,1,0,-1};

    public static void main(String[] args) {
        int[][] a={{1, 2, 1, 2, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0,0, 0, 2, 1},
                {0, 1, 0, 1, 0}};
        int fresh=0;
        int bad=0;
        int time=0;
        Queue<Index> q= new LinkedList<>();
        for (int i = 0; i <X ; i++) {
            for (int j = 0; j <Y ; j++) {
                int b=a[i][j];
                if(b==1){
                    fresh++;
                }else if(b==2){
                    bad++;
                    q.offer(new Index(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Index index=q.poll();
            time++;
            int x=index.x;
            int y=index.y;
            for (int i = 0; i <xs.length ; i++) {
                int nx=x+xs[i];
                int ny=y+ys[i];
                if(nx>=0&&nx<X&&ny>=0&&ny<Y&&a[nx][ny]==1){
                    fresh--;
                    bad++;
                    a[nx][ny]=2;
                    q.offer(new Index(nx,ny));
                }
            }
        }
//        if(fresh>0){
//            System.out.println("");
//        }
        System.out.printf("新鲜的橘子还有%d个\n腐烂的橘子有%d个\n总共经历了%d分钟",fresh,bad,time);
    }
}
class Index{
    int x;
    int y;
    public Index(int x,int y){
        this.x=x;
        this.y=y;
    }
}