package data_structrue.Sorts;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 前k的大元素
 */
public class PriorityQueueHeap {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9,6,5,3,2,1,3,4,5,9,0};
        int k=3;
        PriorityQueue<Integer> pq=new PriorityQueue<>(3);
        for (int i = 0; i <a.length ; i++) {
            if(pq.size()<3){
                pq.add(a[i]);
            }else {
                if (pq.peek()<a[i]) {
                    pq.poll();
                    pq.add(a[i]);
                }
            }
        }
        for (int i = 0; i <k ; i++) {
           Integer res= pq.poll();
            System.out.print(res+",");
        }

    }
}
