package Key_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CVTE_Graph {
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer> path=new ArrayList<>();
        int w=sc.nextInt();
        int origin=sc.nextInt();
        int end=sc.nextInt();
        int[][] cities=new int[w][w];
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j <cities[i].length ; j++) {
                cities[i][j]=sc.nextInt();
            }
        }
        int[][] martrix=new int[w][w];
        for (int i = 0; i <cities.length ; i++) {
            int[] line=cities[i];
            int start=line[0],dst=line[1];
            martrix[start][dst]=line[2];
        }

        int len=martrix.length;
        int[] visited=new int[len];
        dfs(origin,end,martrix,visited,0);
        System.out.println(min);
        for (int i = 0; i <martrix.length ; i++) {
            for (int j = 0; j < martrix[i].length; j++) {
                System.out.print(martrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void dfs(int cur,int end,int[][] martrix,int[] visited,int dist){
        if(dist>min){
            return;
        }
        if(cur==end){
            if(dist<min){
                min=dist;
                return;
            }
        }
        for (int i = 0; i <martrix.length ; i++) {
                if(visited[i]==0&&martrix[cur][i]>0){
                    visited[i]=1;
                    dfs(i,end,martrix,visited,dist+martrix[cur][i]);
                    visited[i]=0;
                }
            }
        }
}
