package Key_questions.PreparedForHuaWei;

import java.util.ArrayList;
import java.util.List;

public class LeetCode47 {
    List<List<Integer>> res = null;
    List<Integer> p = null;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        p = new ArrayList<>();
        int len = nums.length;
        int[] visited = new int[len];
        // Arrays.sort(nums);
        dfs(nums, len, visited);
        return res;
    }
    private void dfs(int[] nums, int len, int[] visited) {
        if (p.size() == len) {
            List<Integer> list = new ArrayList<>(p);
            if (isExits(p) == false) {
                res.add(list);
            }
            return;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            p.add(nums[i]);
            dfs(nums, len, visited);
            visited[i] = 0;
            p.remove(p.size() - 1);
        }
    }
    private boolean isExits(List<Integer> p) {
        for (List<Integer> p1 : res) {
            if (p1.toString().equals(p.toString())) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        LeetCode47 lc=new LeetCode47();
        int[] a={3,3,0,3};
        List<List<Integer>> res = lc.permuteUnique(a);
        for (List<Integer> re : res) {
            System.out.println(re.toString());
        }
    }
}

