package Key_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 从左上角走(0,0)到右下角(n,m)的路径数目，注意，方向只能向下or向右
 * 动态规划（*）：转移方程: f(n,m)=f(n-1,m)+f(n,m-1)，即到目的节点的路径数目等于到左边和到上边节点的路径数目之和。
 */
public class MigongPlus {
    static int[] right={1,0};
    static int[] down={0,1};
    static int min=Integer.MAX_VALUE;
    static List<Integer> list=new ArrayList<>();
    public static void main(String[] args) {
//        int result = computePaths(map);
//        System.out.println(result);
//        int minPath=computeMinPaths(map);
//        System.out.println(minPath);
        int[][] map=initMap();
        int min=dfs_method(map);
        System.out.println(min);
    }
    public static int[][] initMap(){
        int[][] map={{3,2,1},{2,3,1},{1,2,3}};
        return map;
    }
    public static int computePaths(int[][] map){
        int n=map.length;
        int m=map[0].length;
        int[][] num=new int[n][m];
        for (int i = 0; i <n ; i++) {
            num[i][0]=1;
        }
        for (int i = 0; i <m ; i++) {
            num[0][i]=1;
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <m ; j++) {
                num[i][j]=num[i-1][j]+num[i][j-1];
            }
        }
        return num[n-1][m-1];
    }

    public static int computeMinPaths(int[][] map){
        int tsp=0;
        int[][] num=map.clone();
        for (int i = 0; i <map.length ; i++) {
            for (int j = 0; j <map[0].length ; j++) {
                if(i==0&&j==0){continue;}
                int dst1=Integer.MAX_VALUE;
                int dst2=Integer.MAX_VALUE;
                if(i>0){dst1=num[i-1][j];}
                if(j>0){dst2=num[i][j-1];}
                tsp=Math.min(dst1,dst2);
                num[i][j]+=tsp;
            }
        }
        return num[map.length-1][map[0].length-1];
    }
    public static int dfs_method(int[][] map){
        int n=map.length;
        int m=map[0].length;
        int[][] visite=new int[n][m];
        dfs(map,0,0,visite,0);
        return min;
    }
    public static void dfs(int[][] map,int n,int m,int[][] visited,int step ){
        if(n==0&&m==0){
            step+=map[n][m];
        }
        if(n==map.length-1&&m==map[0].length-1){
            if(min>step){
                min=step;
                return;
            }else{
                return;
            }
        }
        visited[n][m]=1;
        for (int i = 0; i <right.length ; i++) {
                int dx=n+right[i];
                int dy=m+down[i];
                if(dx<map.length&&dy<map[0].length&&visited[dx][dy]==0){
                    dfs(map,dx,dy,visited,step+map[dx][dy]);
                    visited[dx][dy]=0;
            }
        }
    }
}
