package Key_questions;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 1,2,2,3,4,5 字符串排列，4不能在头上，3,4不能挨着
 */
public class StrPailie {
    private int[] a={1,2,2,3,4,5};
    private int n=a.length;
    private HashSet<String> set=new HashSet<>();
    private HashSet<String> set2=new HashSet<>();
    private int[] visited=new int[n];
    private int[][] matrix=new int[n][n];
    private void initMap(){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(i!=j){
                    matrix[i][j]=1;
                }else{
                    matrix[i][j]=0;
                }
            }
        }
        matrix[3][4]=0;
        matrix[4][3]=0;
    }
    public static void main(String[] args) {
        StrPailie sp=new StrPailie();
        sp.initMap();
        sp.way1_graph(sp);
        sp.way2(sp);

        for (String s : sp.set) {
            System.out.print(s+",");
        }

        for (String s : sp.set2) {
            System.out.print(s+",");
        }
        System.out.println();
        System.out.println(sp.set.size());
        System.out.println(sp.set2.size());
    }
    public void way2(StrPailie sp){
        for (int i = 0; i <sp.n ; i++) {
            if(a[i]!=4) {
                visited[i]=1;
                String s=""+a[i];
                dfs01(i, s);
                Arrays.fill(visited,0);
            }
        }
    }
    public void dfs01(int i,String s){
        if(s.length()==n){
            int i1=s.indexOf('3');
            int i2=s.indexOf('4');
            String sub="";
            if(i1<i2){
                sub=s.substring(i1,i2+1);
                if(!sub.equals("34")){
                    set2.add(s);
                }
            }else{
                sub=s.substring(i2,i1+1);
                if(!sub.equals("43")){
                    set2.add(s);
                }
            }
        }
        for (int j = 0; j <n ; j++) {
            if(visited[j]==0){
                visited[j]=1;
                s+=a[j];
                dfs01(j,s);
                visited[j]=0;
                s=s.substring(0,s.length()-1);
            }
        }
    }
    public void way1_graph(StrPailie sp){
        for (int i = 0; i <sp.n ; i++) {
            sp.dfs(i,"");
            Arrays.fill(sp.visited,0);
        }
        for (String s : sp.set) {
            System.out.print(s+",");
        }
    }
    private void dfs(int i,String s){
        if(s.length()==n){
            if(s.charAt(0)!='4') {
                set.add(s);
            }
        }
        for (int j = 0; j <n ; j++) {
            if(visited[j]==0&&matrix[i][j]==1){
                visited[j]=1;
                s+=a[j];
                dfs(j,s);
                visited[j]=0;
                s=s.substring(0,s.length()-1);
            }
        }
    }
}
