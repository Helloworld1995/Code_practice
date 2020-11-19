package Key_questions.PreparedForHuaWei;


import java.util.HashSet;
import java.util.Set;

public class LeetCode1220 {
    int[][] map=null;
    int[][] visited=null;
    Set<String> set=new HashSet<>();
    int count=0;
    public int countVowelPermutation(int n) {
        char[] cs={'a','e','i','o','u'};
        int len=cs.length;
        map=new int[len][len];
        visited=new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(cs[i]=='i'&&cs[j]!='i'){
                    map[i][j]=1;
                }
                if(cs[i]=='a'&&cs[j]=='e'){
                    map[i][j]=1;
                }
                if(cs[i]=='e'&&(cs[j]=='a'||cs[j]=='i')){
                    map[i][j]=1;
                }
                if(cs[i]=='o'&&(cs[j]=='u'||cs[j]=='i')){
                    map[i][j]=1;
                }
                if(cs[i]=='u'&&cs[j]=='a'){
                    map[i][j]=1;
                }
            }
        }
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i <len ; i++) {
            dfs(i,n,0,sb,cs);
            sb=new StringBuffer();
        }
        return count;
    }

    private void dfs(int cur,int n,int len,StringBuffer sb,char[] cs){
        if(len==n){
            String s=sb.toString();
            if(set.add(s)) {
                count++;
            }
            return;
        }
        for(int i=0;i<map.length;i++){
            if(map[cur][i]==1&&visited[cur][i]==0){
                sb.append(cs[i]);
                len++;
                visited[cur][i]=1;
                dfs(i,n,len,sb,cs);
                len--;
                sb.deleteCharAt(sb.length()-1);
                visited[cur][i]=0;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode1220 leetcode=new LeetCode1220();
        int res=leetcode.countVowelPermutation(100);
        System.out.println(res);
    }

}

