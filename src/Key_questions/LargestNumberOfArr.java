package Key_questions;

import java.util.*;

/**
 * 将数组中的元素拼接组成最大数字
 */
public class LargestNumberOfArr {
    static Scanner sc=new Scanner(System.in);
    static int max=0;
    public static void main(String[] args) {
        int[] a = new int[sc.nextInt()];
//        String result=compare_way(a);
//        System.out.println(result);
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        Dfs_way(a);
    }
    public static String compare_way(int[] a){
        String resut="";
        List<String> list=new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
            list.add(String.valueOf(a[i]));
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int i1=Integer.parseInt(o1+o2);
                int i2=Integer.parseInt(o2+o1);
                return i2-i1;
            }
        });
        for (String s : list) {
            resut+=s;
        }
        return resut;
    }
    public static void Dfs_way(int[] a){
        int[] visited=new int[a.length];
        int step=0;
        dfs(a,visited,step,"",0);
        System.out.println(max);

    }
    public static void dfs(int[] a,int[] visited,int step,String temp,int lastlen){
        if(step==a.length){
            int value=Integer.parseInt(temp);
            if(max<value){
                max=value;
            }
            return;
        }
        for (int i = 0; i <a.length ; i++) {
            if(visited[i]==0){
                temp+=a[i];
                visited[i]=1;
                lastlen=String.valueOf(a[i]).length();
                dfs(a,visited,step+1,temp,lastlen);
                visited[i]=0;
                temp=temp.substring(0,temp.length()-lastlen);
            }
        }
    }
}
