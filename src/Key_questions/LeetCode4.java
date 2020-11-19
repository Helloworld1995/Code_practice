package Key_questions;

import java.util.Arrays;

public class LeetCode4 {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,7};
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        int middle = len / 2;
        int[] a = new int[middle+1];
        double res = 0;
        int j = 0;
        int a1 = 0, a2 = 0;
        while (j <= middle && a1 < len1 && a2 < len2) {
            if(a1 < len1 && a2 < len2&&nums1[a1] >= nums2[a2]) {
                a[j] = nums2[a2];
                a2++;
            }else if(a1 < len1 && a2 < len2&&nums1[a1] < nums2[a2]) {
                a[j] = nums1[a1];
                a1++;
            }
            j++;
        }
            while (j<=middle&&a1 < len1) {
                a[j] = nums1[a1];
                j++;
                a1++;
            }
            while (j<=middle&&a2 < len2) {
                a[j] = nums2[a2];
                j++;
                a2++;
            }
        System.out.println(Arrays.toString(a));
            if (len % 2 == 0) {
                res = (a[middle] + a[middle - 1]) / 2.0;
            } else {
                res = a[middle];
            }
            return res;
        }
    }



