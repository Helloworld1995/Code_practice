package Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String> list=new ArrayList<>();
        String n=null;
        while(sc.hasNext()){
            n=sc.nextLine();
            if(n.length()==1){
                break;
            }
            list.add(n);
        }
        String target=sc.nextLine();
        String s = sig(target, n);
        if(isLegal(n)){
            process(list,Integer.parseInt(n),s);
        }
    }
    public static String sig(String target,String n){
        int i = Integer.parseInt(n);
        String res="";
        for (int j = 0; j <target.length() ; j++) {
            char c=target.charAt(j);
            if((int)(c-'0')<i){
                res+=c;
            }
        }
        return res;
    }
    public static boolean isLegal(String n){
        int temp=Integer.parseInt(n);
        if(temp>1&&temp<=9){
            return true;
        }
        return false;
    }
    public static void process(List<String> list,Integer n,String target){
        String temp="";
        for (int i = 0; i <list.size() ; i++) {
            String s="";
            String str=list.get(i);
            for (int j = 0; j<str.length() ; j++) {
                char c=str.charAt(j);
                if(n>(int)(c-'0')){
                    s+=c;
                }
            }
            if(s.contains(target)){
                System.out.println(str);
            }
        }
    }

}



