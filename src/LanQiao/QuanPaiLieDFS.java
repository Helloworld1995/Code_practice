package LanQiao;

import java.util.HashSet;

/**
 * DFS实现全排列
 */
public class QuanPaiLieDFS {
    private boolean[] visited;
    String result="";
    HashSet<String> results;
    char[] cs;
    public QuanPaiLieDFS(char[] cs){
        this.visited=new boolean[cs.length];
        results=new HashSet<>();
        this.cs=cs;
    }
    public void dfs(int i){
        visited[i]=true;
        result+=cs[i];
        if(result.length()==cs.length){
            results.add(result);
        }

        for (int j = 0; j <cs.length ; j++) {
            if(visited[j]==false) {
                dfs(j);
            }
        }
        result=result.substring(0,result.length()-1);
        visited[i]=false;

    }


    public static void main(String[] args) {
        String s="abcdefg";
        char[] cs = s.toCharArray();
        QuanPaiLieDFS q=new QuanPaiLieDFS(cs);
        for (int i = 0; i <4 ; i++) {
            q.dfs(i);
        }
        int count=0;
        for (String result : q.results) {
            count++;
            System.out.println(result);
        }
        System.out.println(count);
    }
}
