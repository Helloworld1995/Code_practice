package Key_questions;

import java.util.Arrays;

/**
 * 归并两个有序数组
 */
public class Merge2Arr {
    public static void main(String[] args) {
        int[] a1 = {1,2,3};
        int[] a2 = {2,4,6};
        int[] result=way2(a1,a2);
        System.out.println(Arrays.toString(result));
//        int[] a = way1(a1, a2);
//        System.out.println(Arrays.toString(a));
    }

    /**
     * 将两个排序的数组归并，归并到第一个数组中。从尾部还是遍历，两个数组从尾部遍历并依次比较，将大数放到
     * 放入第一个数组的当前遍历下标处(从尾部遍历)，最终归并结束。
     * @param a1
     * @param a2
     * @return
     */
    public static int[] way2(int[] a1,int[] a2){
        int len=a1.length+a2.length;
        int[] a = Arrays.copyOf(a1, len);
        int mergeIndex=len-1;
        int index1=a1.length-1;
        int index2=a2.length-1;
        while(mergeIndex>=0){
            if(index1<0){
                a[mergeIndex]=a2[index2];
                mergeIndex--;
                index2--;
            }
            if(index2<0){
                a[mergeIndex]=a1[index1];
                mergeIndex--;
                index1--;
            }
            if(index1>=0&&index2>=0){
                if(a1[index1]>a2[index2]){
                    a[mergeIndex]=a1[index1];
                    index1--;
                    mergeIndex--;
                }else if(a1[index1]<=a2[index2]){
                    a[mergeIndex]=a2[index2];
                    index2--;
                    mergeIndex--;
                }
            }
        }
        return a;
    }

    public static int[] way1(int[] a1,int[] a2){
            int[] a3=new int[a1.length+a2.length];
            int i=0;
            int i1=0;
            int j1=0;
            while(i<a3.length&&i1<a1.length&&j1<a2.length){
                if(a1[i1]<a2[j1]){
                    a3[i]=a1[i1];
                    i1++;
                }else{
                    a3[i]=a2[j1];
                    j1++;
                }
                i++;
            }
            if(i<a3.length){
                if(i1<a1.length){
                    for (int j = i; j <a3.length ; j++) {
                        a3[j]=a1[i1];
                        i1++;
                    }
                }else if(j1<a2.length){
                    for (int j = i; j <a3.length ; j++) {
                        a3[j]=a2[j1];
                        j1++;
                    }
                }
            }
            return a3;
        }
    }

