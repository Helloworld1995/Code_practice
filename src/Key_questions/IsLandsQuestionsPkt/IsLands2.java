package Key_questions.IsLandsQuestionsPkt;

import java.util.Scanner;

/**
 * 求最大岛屿面积
 */
public class IsLands2 {
    static final int X=5;
    static final int Y=5;
    static final int[] xs={1,0,-1,0};
    static final int[] ys={0,1,0,-1};
    static int size=0;
    public static void main(String[] args) {
        int[][] sea={{1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {1,1,0,1,1},
                {0,0,0,1,0}};
        int maxSize=-1;
        for (int i = 0; i <X ; i++) {
            for (int j = 0; j <Y ; j++) {
                if(sea[i][j]==1){
                    deepSearch(sea,i,j);
                    if(maxSize<size){
                        maxSize=size;
                    }
                    size=0;
                }
            }
        }
        System.out.println(maxSize);
    }
    public static void deepSearch(int[][] sea,int i,int j){
        for (int k = 0; k <xs.length ; k++) {
            int newX=i+xs[k];
            int newY=j+ys[k];
            if(newX>=0&&newX<X&&newY>=0&&newY<Y&&sea[newX][newY]==1){
                size++;
                sea[newX][newY]=0;
                deepSearch(sea,newX,newY);
            }
        }
    }
}
