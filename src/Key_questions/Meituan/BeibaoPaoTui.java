package Key_questions.Meituan;

import java.util.*;

public class BeibaoPaoTui {
    static Map<String,Integer> map=new HashMap<>();
    static int maxValue=-1;
    static String str="";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] all=init(n);
        int[] max=new int[m];
        int[][] vx=new int[n][2];
        for (int i = 0; i <n ; i++) {
            vx[i][0]=sc.nextInt();
            vx[i][1]=sc.nextInt();
        }
        paiLie(n,m,all,max,m,vx);
        System.out.println(str);

    }
    public static int[] init(int n){
        int[] a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=i+1;
        }
        return a;
    }

    public static void paiLie(int n,int m,int[] all,int[] max,int M,int[][] vx){
        for (int k = m; k <=n ; k++) {
            max[m-1]=k-1;
            if(m>1){
                paiLie(k-1,m-1,all,max,M,vx);
            }else{
                int value=0;
                String s="";
                for (int l = 0; l <=M-1 ; l++) {
                    int index=all[max[l]];
                    value+=vx[index-1][0]+vx[index-1][1]*2;
                    s=s+String.valueOf(index)+" ";
//                    System.out.print(all[max[l]]+" ");
                }
                if(maxValue<value){
                    maxValue=value;
                    str=s;
                }else if(maxValue==value){
                    if(str.compareTo(s)>0){
                        str=s;
                    }
                }
            }
        }
    }
}
