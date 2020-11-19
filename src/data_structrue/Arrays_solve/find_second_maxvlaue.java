package data_structrue.Arrays_solve;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *找到数组倒数第二大数字
 */
public class find_second_maxvlaue {
    public static int find_secondMaxVlaue(int[] a) {
        int max = a[0];
        int sec_max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                sec_max = max;
                max = a[i];
            } else if (a[i] > sec_max) {
                sec_max = a[i];
            }
        }
        return sec_max;
    }

    /**
     * 找到重复次数最多的数
     * @param a
     * @return
     */
    public static int find_max_repeat_number(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int value = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);
            } else {
                map.put(a[i], map.get(a[i]) + 1);
            }
        }
        for (Integer i : map.keySet()) {
            int temp = map.get(i);
            if (temp > max) {
                max = temp;
                value = i; }
            }
            return value;
        }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,0};
        System.out.println(find_secondMaxVlaue(a));
        int[] a1 = new int[]{1,1,1,1,2,4,1,1,2,3,58,7,4,14,78,4,11,5,1,5,2,2,2,33,56};
        System.out.println(find_max_repeat_number(a1));
    }
}
