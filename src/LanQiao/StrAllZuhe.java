package LanQiao;

import java.util.*;

/**
 * 字符串所有组合a,b,c -->a,b,c,ab,ac,bc,abc;
 */
public class StrAllZuhe {
    static Set<String> set=new HashSet<>();
    public static void main(String[] args) {
//        perm("abc");
        long start1=System.currentTimeMillis();
        baoli("abcde");
        long end1=System.currentTimeMillis();
        System.out.printf("暴力方法耗时%d\t:",(end1-start1));
        long start2=System.currentTimeMillis();
        System.out.println();
        perm("fghijklmnopqrstuvwxyz");
        long end2=System.currentTimeMillis();
        System.out.printf("骚操作耗时%d\t:",(end2-start2));
        System.out.println();
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println(set.size());
    }
    public static void perm(String s){
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i <=s.length() ; i++) {
         perm(s,i,result);
        }
    }
    public static void perm(String s,int m,ArrayList<String> result){
        if(m==0){
            for (int i = 0; i <result.size() ; i++) {
                System.out.print(result.get(i));

            }
            System.out.print("|");
            return;
        }
        if(s.length()!=0){
            result.add(s.charAt(0)+" ");
            perm(s.substring(1,s.length()),m-1,result);
            result.remove(result.size()-1);
            perm(s.substring(1,s.length()),m,result);
        }
    }
    public static void baoli(String s){
        int[] visited=new int[s.length()];
        String tempStr="";
//        baoliDfs(s,visited,3,tempStr,0);
        for (int i = 1; i <=s.length(); i++) {
            baoliDfs(s,visited,i,tempStr,0);
            tempStr="";
            Arrays.fill(visited,0);
        }
    }
    public static void baoliDfs(String s,int[] visited,int num,String result,int j){
        if(num==0){
            set.add(result);
            return;
        }
        for (int i = j; i <s.length() ; i++) {
            if(visited[i]==0){
                int k=i;
                result+=s.charAt(i);
                visited[i]=1;
                baoliDfs(s,visited,num-1,result,k);
                visited[i]=0;
                result=result.substring(0,result.length()-1);
            }
        }

    }
}
