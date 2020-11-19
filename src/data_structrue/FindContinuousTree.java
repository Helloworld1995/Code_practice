package data_structrue;

import java.util.*;

/**
 * inpure 第二道题，道路 两侧种满树，有坏人砍掉了其中的一些，求最长连续的树
 */
public class FindContinuousTree {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] steelIndex=new int[n];
        for (int i = 0; i <n ; i++) {
            steelIndex[i]=sc.nextInt();
        }
        List<Integer> one=new ArrayList<>();
        List<Integer> two=new ArrayList<>();
        for (int i = 1; i <=100 ; i++) {
            if(i%2==0){
                two.add(i);
            }else{
                one.add(i);
            }
        }
        int[] result = run(n, steelIndex, one, two);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
    public static int[] run(int n,int[] steelIndex,List<Integer> one,List<Integer> two){
        int max=0;
        int start=-1;
        int[] result=new int[2];
        List<Integer> oneIndexs=new ArrayList<>();
        List<Integer> twoIndexs=new ArrayList<>();
        Arrays.sort(steelIndex);
        for (int index : steelIndex) {
            if(one.contains(index)){
                oneIndexs.add(one.indexOf(index));
            }
            if(two.contains(index)){
                twoIndexs.add(two.indexOf(index));
            }
        }
        if(oneIndexs.size()<=1){
            int temp=50-(oneIndexs.get(0)+1);
            if(temp>max){
                max=temp;
                start=one.get(oneIndexs.get(0)+1);
            }
        }else {
            for (int i = 0; i < oneIndexs.size() - 1; i++) {
                int first = oneIndexs.get(i);
                int seconde = oneIndexs.get(i + 1);
                int temp = seconde - first;
                if (temp > max) {
                    max = temp;
                    start = first+1;
                }
            }
        }
        if(twoIndexs.size()<=1){
            int temp=50-(twoIndexs.get(0)+1);
            if(temp>max){
                max=temp;
                start=two.get(twoIndexs.get(0)+1);
            }
        }else {
            for (int i = 0; i < twoIndexs.size() - 1; i++) {
                int first = twoIndexs.get(i);
                int seconde = twoIndexs.get(i + 1);
                int temp = seconde - first;
                if (temp > max) {
                    max = temp;
                    start = first+1;
                }
            }
        }
        result[0]=start;
        result[1]=max;
        return result;
    }
}
