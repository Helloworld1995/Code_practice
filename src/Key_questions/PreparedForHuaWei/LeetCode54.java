package Key_questions.PreparedForHuaWei;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    public static void main(String[] args) {
        LeetCode54 leetcode=new LeetCode54();
        int[][] martrix={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                };
        List<Integer> res = leetcode.spiralOrder(martrix);
        System.out.println(res.toString());
    }
    public List<Integer> spiralOrder(int[][] martirx){
        int left=0,right=martirx[0].length;
        int top=0,bottom=martirx.length;
        List<Integer> res=new ArrayList<>();
        int total=right*bottom;
        while(left<=right&&top<bottom&&res.size()<total){
            for (int i = left; i <right ; i++) {
                res.add(martirx[top][i]);
            }
            if(top+1<bottom) {
                for (int i = top + 1; i <bottom; i++) {
                    res.add(martirx[i][right-1]);
                }
            }
            if(right-1>left&&res.size()<total) {
                for (int i = right - 2; i >= left; i--) {
                    res.add(martirx[bottom-1][i]);
                }
            }
            if((bottom-1>top+1)&&res.size()<total) {
                for (int i = bottom - 2; i >= top + 1; i--) {
                    res.add(martirx[i][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }
}
