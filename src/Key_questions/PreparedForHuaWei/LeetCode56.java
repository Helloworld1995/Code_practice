package Key_questions.PreparedForHuaWei;

import java.util.*;

public class LeetCode56 {
    public static void main(String[] args) {
        LeetCode56 leetcode=new LeetCode56();
        int[][] a={{1,4},{0,0}};
        int[][] res = leetcode.merge(a);
        printArr(res);
    }
    private static void printArr(int[][] a){
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[0].length ; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        LinkedList<int[]> list=new LinkedList<>();
        int len = intervals.length;
        for(int i=0;i<len;i++) {
            int[] a = intervals[i];
            if (!list.isEmpty()) {
                int[] temp = list.getLast();
                if (temp[1] < a[0]) {
                    list.offer(a);
                }else{
                    temp[1] = Math.max(temp[1], a[1]);
                }
            }else{
                list.offer(a);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
