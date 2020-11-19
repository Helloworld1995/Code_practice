package data_structrue;

import java.util.*;

public class Test{
    List<List<Integer>> res=null;
    List<Integer> path=null;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res=new ArrayList<>();
        path=new ArrayList<>();
        int len=candidates.length;
        if(len==0){
            return res;
        }
        dfs(candidates,0,target,len);
        return res;
    }
    private void dfs(int[] candidates,int begin,int target,int len){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList(path));
            return;
        }
        for(int i=begin;i<len;i++){
            path.add(candidates[i]);
            dfs(candidates,i,target-candidates[i],len);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        Test test=new Test();
        int[] a={2,3,6,7};
        List<List<Integer>> res = test.combinationSum(a, 7);
        for (List<Integer> re : res) {
            System.out.println(re.toString());
        }

    }
}
