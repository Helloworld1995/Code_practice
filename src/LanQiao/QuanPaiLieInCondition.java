package LanQiao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 按要求计算数组排列：要求“4”不能放在第三位，“3”和“5”不能相连
 */
public class QuanPaiLieInCondition {
    private int[] nodes;
    private int n;
    private boolean[] visited;
    int[][] graph;
    String result="";
    Set<String> set=new HashSet<>();
    public QuanPaiLieInCondition(int[] nodes){
        this.nodes=nodes;
        n=nodes.length;
        visited=new boolean[n];
        Arrays.fill(visited,false);
        graph=new int[n][n];
    }
    public void buildGraph(){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n ; j++) {
                if(i==j||(i==3&&j==5)||(i==5&&j==3)){
                    graph[i][j]=0;
                }
                else{
                    graph[i][j]=1;
                }
            }
        }
        for (int i = 0; i <n ; i++) {
            run(i);
        }

    }
    public void printGraph(){
        for (int i = 0; i <graph.length ; i++) {
            for (int j = 0; j <graph.length ; j++) {
                System.out.print(graph[i][j]+",");
            }
            System.out.println();
        }
    }
    public void run(int i){
        visited[i]=true;
        result+=nodes[i];
        if(result.length()==nodes.length){
            if(result.indexOf('4')!=2){
                set.add(result);
            }
        }
        for (int j = 0; j <n ; j++) {
            if(graph[i][j]==1&&visited[j]==false){
                run(j);
            }
        }
        result=result.substring(0,result.length()-1);
        visited[i]=false;
    }

    public static void main(String[] args) {
        int[] nodes={1,2,2,3,4,5};
        QuanPaiLieInCondition q=new QuanPaiLieInCondition(nodes);
        q.buildGraph();
        for (String s : q.set) {
            System.out.println(s);
        }
    }

}
