package data_structrue;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class StrsComposed {
    static ArrayList<String> list=new ArrayList<>();
    public static void main(String[] args) {
        String result="";
        String[] s={"def","abc","ghi","vda","irq","ool","vaq","tyvax"};
//        mySort(s);
//        String mindictStr=Baoli(s);
//        System.out.println(mindictStr);
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for (String s1 : s) {
            result+=s1;
        }
        System.out.println(result);
    }

    /**
     * 按字典序组合排序
     * @param s
     */
    public static void mySort(String[] s){
        for (int i = 0; i <s.length-1 ; i++) {
            for (int j = i+1; j < s.length-i; j++) {
                String s1=s[i];
                String s2=s[j];
                if((s1+s2).compareTo(s2+s1)>0){
                     swap(s,i,j);
                }
            }
        }
    }


    public static String Baoli(String[] s) {
        int[] visited = new int[s.length];
        dfs(s, visited,  0, new ArrayList<String>());
        String minDictStr = list.get(0);
        for (String s1 : list) {
            if (minDictStr.compareTo(s1) >0) {
                minDictStr=s1;
            }
        }
        return minDictStr;
    }
    /**
     * 暴力dfs
     * @param s
     */
    public static void dfs(String[] s,int[] visited,int step,ArrayList<String> result){
        if(step==visited.length){
            String ss="";
            for (String s1 : result) {
                ss+=s1;
            }
            list.add(ss);
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if(visited[i]==0){
                visited[i]=1;
                result.add(s[i]);
                dfs(s,visited,step+1,result);
                result.remove(result.size()-1);
                visited[i]=0;
            }
        }
//        result.remove(result.size()-1);
    }

    public static void swap(String[] s,int i,int j){
        String temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }
}
