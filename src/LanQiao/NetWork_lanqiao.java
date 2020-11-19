package LanQiao;

import java.util.*;

/**
 * 蓝桥杯最后一题
 */
public class NetWork_lanqiao {
    HashMap<String, ArrayList<String>> map;
    HashMap<String,Integer>  message;
    int size;
    public NetWork_lanqiao(int size){
        this.map=new HashMap<>();
        this.message=new HashMap<>();
        this.size=size;
        this.init();
    }
    public void init(){
        for (int i = 1; i <= size; i++) {
            String k=String.valueOf(i);
            if(!map.containsKey(k)){
                map.put(k,new ArrayList<String>());
            }
            if(!message.containsKey(k)){
                message.put(k,0);
            }
        }
    }
    public void transfer(String[] seg){
        String node=seg[1];
        int value=Integer.parseInt(seg[2]);
        Queue<String> q=new LinkedList<>();
        q.offer(node);
        int[] visited=new int[size+1];
        while(!q.isEmpty()){
            String temp=q.poll();
            for (String s : map.get(temp)) {
                if(visited[Integer.parseInt(s)]==0){
                    int msg=this.message.get(s);
                    this.message.put(s,msg+value);
                    q.offer(s);
                    visited[Integer.parseInt(s)]=1;
                }
            }
        }
    }
    public void build(String[] seg){
        String node1=seg[1];
        String node2=seg[2];
        ArrayList<String> links=map.get(node1);
        ArrayList<String> links2=map.get(node2);
        links.add(node2);
        links2.add(node1);
        map.put(node1,links);
        map.put(node2,links2);
    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       NetWork_lanqiao nl=new NetWork_lanqiao(n);
       int m=sc.nextInt();//nextInt后追加一个空行，也被nextLine给读取了。
       sc.nextLine();
       while(m>0){
           String s=sc.nextLine();
           String[] seg = s.split(" ");
           if(seg[0].equals("1")){
               nl.build(seg);
           }else if(seg[0].equals("2")){
               nl.transfer(seg);
           }
           m--;
       }

        HashMap<String, ArrayList<String>> map = nl.map;
        HashMap<String, Integer> message =nl.message;
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        for (Map.Entry<String, Integer> entry2 : message.entrySet()) {
            System.out.println(entry2.getKey()+":"+entry2.getValue());
        }

    }
}
