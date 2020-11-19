package data_structrue.Dijkstra;

import java.util.Scanner;

public class My_dijkstra {
    public static final int MaxValue=10000;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入节点数目，边的数目:");
        int vertex=sc.nextInt();
        int edges=sc.nextInt();
        int[][] map=new int[vertex][vertex];
        for (int i = 0; i <vertex ; i++) {
            for (int j = 0; j <vertex ; j++) {
                map[i][j]=MaxValue;
            }
        }
        System.out.println("请输入边的节点对以及边权");
        for (int i = 0; i <edges ; i++) {
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int weight=sc.nextInt();
            map[src][dst]=weight;
        }
        System.out.println("输入源节点");
        int source=sc.nextInt();
        System.out.println("输入流量需求");
        int demand=sc.nextInt();
        dijkstra(map,source,demand);
    }
    public static void dijkstra(int[][] map,int source,int demand){
        int[] shortest=new int[map.length];
        int[] visited=new int[map.length];
        String[] path=new String[map.length];
        for (int i = 0; i <path.length ; i++) {
            path[i]=source+"-"+i;
        }
        shortest[source]=0;//初始化源节点
        visited[source]=1;
        for (int i = 1; i <map.length ; i++) {
            int min=MaxValue;
            int index=-1;
            for (int j = 0; j <map.length ; j++) {
                if(visited[j]==0&&map[source][j]<min){
                    min=map[source][j];
                    index=j;
                }
            }
            shortest[index]=min;
            visited[index]=1;
            for (int k = 0; k < map.length; k++) {
                if(visited[k]==0&&map[source][k]>map[source][index]+map[index][k]){
                    map[source][k]=map[source][index]+map[index][k];
                    path[k]=path[index]+"-"+k;
                }
            }
        }
        for (int i = 0; i <map.length ; i++) {
            if(i!=source){
                if(shortest[i]==MaxValue){
                    System.out.println(source+"到"+i+"不可达");
                }else{
                    System.out.println(source+"到"+i+"的最短路径:"+path[i]+",最短距离是："+shortest[i]);
                }
            }
        }

    }

}
