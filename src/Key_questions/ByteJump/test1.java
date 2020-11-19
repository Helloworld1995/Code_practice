package Key_questions.ByteJump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class test1 {
    private HashMap<Integer,int []> trie;
    private HashMap<Integer, HashSet<Integer>> adj;
    private boolean visited[];
    private boolean hascycle;
    public void test(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//n表示t个测试数据3
        for (int x = 0; x < n ; x++) {
            int m = in.nextInt();//m表示n条线段
            visited = new boolean[m];
            trie = new HashMap<>();
            adj = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                trie.put(i, new int[]{a,b});
                HashSet set  = new HashSet();
                for (int j = 0; j < i; j++) {//判断i和j是否右边
                    if(isedge(a, b, trie.get(j)[0], trie.get(j)[1])){//表示有边
                        set.add(j);
                        adj.get(j).add(i);
                    }
                }
                adj.put(i, set);
            }
            if(!hascycle()){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }


    }
    private boolean hascycle(){

        dfs(0,-1);
        if(hascycle){//有环
            return false;
        }
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                return false;
            }
        }
        return true;

    }
    private void dfs(int v,int pre){
        visited[v] = true;
        for(int w: getadj(v)){
            if(!visited[w]){
                dfs(w,v);
            }else{
                if(w != pre){
                    hascycle = true;
                }
            }
        }
    }
    private HashSet<Integer> getadj(int v){
        return  adj.get(v);
    }
    //判断两个节点时否右边
    private boolean isedge(int left1, int right1, int left2, int right2){
        return !(right1<left2 || left1> right2 ||left1>=left2&&right1<right2||left2>=left1&&right2<right1);
    }

    public static void main(String[] args) {
        test1 test1 = new test1();
        test1.test();
    }

}
