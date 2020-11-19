package Key_questions.LRUpkt;

import sun.awt.SunHints;

import java.util.HashMap;
import java.util.Map;

/**
 * 全手写LRU，借助hashmap
 */
public class LRUCache {
    private class Node{
        public Node pre;
        public Node next;
        public int key;
        public int val;
        public Node(int k,int v){
            this.key=k;
            this.val=v;
            this.pre=null;
            this.next=null;
        }
    }
    private class LruLinkList{
        public Node head;
        public Node tail;
        public LruLinkList(){
            this.head=null;
            this.tail=null;
        }
        public void moveToTail(Node n){
            if(n==null|n==tail){
                return;
            }
            if(head==n){
                head=n.next;
                head.pre=null;
            }else{
                n.pre.next=n.next;
                n.next.pre=n.pre;
            }
            tail.next=n;
            n.pre=tail;
            n.next=null;
            tail=tail.next;
        }
        public void addToTail(Node n){
            if(n==null){
                return;
            }
            if(head==null){
                head=n;
                tail=n;
            }else{
                tail.next=n;
                n.pre=tail;
                tail=tail.next;
            }
        }
        public Node removeOld(){
            if(head==null){
                return null;
            }
            Node n=head;
            if(head==tail){
                head=null;
                tail=null;
            }else{
                head=head.next;
                head.pre=null;
            }
            return n;
        }
        public void printLruList(){
            if(head==null){
                return;
            }
            Node n=head;
            while(n!=null){
                System.out.print(n.val+"->");
                n=n.next;
            }
        }
    }
    private LruLinkList list;
    private Map<Integer,Node> map;
    private int capacity;
    public LRUCache(int capactity){
        this.list=new LruLinkList();
        this.map=new HashMap<>();
        this.capacity=capactity;
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node n=map.get(key);
        list.moveToTail(n);
        return n.val;
    }
    public void put(int key,int value){
        if(!map.containsKey(key)){
            Node n=new Node(key,value);
            map.put(key,n);
            list.addToTail(n);
            if(map.size()>capacity){
                Node rmn=list.removeOld();
                map.remove(rmn.key);
            }
        }else{
            Node n=map.get(key);
            n.val=value;
            list.moveToTail(n);
        }
    }
    public void printLru(){
        list.printLruList();
    }

    public static void main(String[] args) {
        LRUCache lru=new LRUCache(10);
        int[] a={1,2,3,4,5,6,7,8,9,10,11,12};
        for (int i = 0; i <a.length ; i++) {
            lru.put(i,a[i]);
        }
        lru.get(5);
        lru.printLru();
    }
}

