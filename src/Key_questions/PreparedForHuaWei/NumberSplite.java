package Key_questions.PreparedForHuaWei;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 输入数字m，输出结果n，n的每一位的平方和等于m，而且是最小的那个
 */
public class NumberSplite {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int m = sc.nextInt();
        int temp=0;
        int result=m-temp;
        int lastNum=0;
        int k=0;
        while(result>0){
            for (int i = 1; i <=9 ; i++) {
                temp=i*i;
                if(result-temp<0){
                    break;
                }else if(result-temp==0){
                    k=i;
                    lastNum=temp;
                    break;
                }
                lastNum=temp;
                k=i;
            }
            pq.offer(k);
            result-=lastNum;
        }
        int size=pq.size();
        for (int i = 0; i <size ; i++) {
            System.out.print(pq.poll());
        }

    }
}
