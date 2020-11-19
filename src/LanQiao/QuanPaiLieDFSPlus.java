package LanQiao;

public class QuanPaiLieDFSPlus {
    public static void main(String[] args) {
        String s="abcdefg";
        StringBuffer sb=new StringBuffer();
        char[] cs = s.toCharArray();
        int[] visited=new int[cs.length];
        dfs(cs,visited,sb);
    }
    public static void dfs(char[] cs,int[] visited,StringBuffer s){
        int len=s.length();
        if(visited.length==len){
            System.out.println(new String(s));
        }
        else{
            for (int j = 0; j <visited.length ; j++) {
                if(visited[j]==0){
                    visited[j]=1;
                    s.append(cs[j]);
                    dfs(cs,visited,s);
                    s.deleteCharAt(s.length()-1);
                    visited[j]=0;
                }
            }
        }
    }
}
