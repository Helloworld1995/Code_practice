package data_structrue;

import java.util.*;

/**
 * 两个有序数组求交集
 */
public class find_Mix_in_2ARR {
    public static List<Integer> getMix1(int[] a1,int[] a2){
        List<Integer> mix=new ArrayList<>();
        int i=0;
        int j=0;
        int n1=a1.length;
        int n2=a2.length;
        while(i<n1&&j<n2){
            if(a1[i]==a2[j]){
                mix.add(a1[i]);
                j++;
                i++;
            }else if(a1[i]>a2[j]){
                j++;
            }else if(a1[i]<a2[j]){
                i++;
            }
        }
        return mix;
    }
    public static List<Integer> getMix2(int[] a1,int[] a2){
        List<Integer> mix=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        int n1=a1.length;
        int n2=a2.length;
        if(n1>n2){
            for (int i = 0; i <n2 ; i++) {
                set.add(a2[i]);
            }
            for (int i = 0; i <n1 ; i++) {
                if(set.contains(a1[i])){
                    mix.add(a1[i]);
                }
            }
        }else{
            for (int i = 0; i <n1 ; i++) {
                set.add(a1[i]);
            }
            for (int i = 0; i <n2 ; i++) {
                if(set.contains(a2[i])){
                    mix.add(a2[i]);
                }
            }
        }
        return mix;
    }
    public static void main(String[] args) {
        int[] a1={1,2,3,4,5,6,7,8,9,10};
        int[] a2={3,4,7,9,12};
        List<Integer> mix = getMix2(a1, a2);
        for (Integer m : mix) {
            System.out.print(m+" ");
        }
    }
}
