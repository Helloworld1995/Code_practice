package Key_questions;


import java.util.HashSet;
import java.util.Set;

public class MyLinkedList {
    Node head = null;
    int size = 0;

    public MyLinkedList(int[] origin) {
        init(origin);
    }
    public MyLinkedList(){

    }

    private void init(int[] origin) {
        for (int i : origin) {
            insert(new Node(i));
        }
    }

    public void insert(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node n = head;
        while (n.getNextNode() != null) {
            n = n.getNextNode();
        }
        n.setNextNode(node);
        size++;
    }

    public void printList() {
        Node n = head;

        while (n != null) {
            System.out.print("->" + n.getNodeData());
            n = n.getNextNode();
        }
    }

    public void reverseList() {
        if (head == null || head.getNextNode() == null) {
            return;
        }
        Node before = null;
        Node cur = head;
        Node behind = null;
        while (cur != null) {
            behind = cur.getNextNode();
            cur.setNextNode(before);
            before = cur;
            cur = behind;
        }
        head = before;
    }

    /**
     * 删除单链表中重复的节点，1,2,2,3删完后：1,2,3
     */
    public void deleteDuplicateNode(){
        Set<Integer> set=new HashSet<>();
        if(head==null){
            return;
        }
        Node cur=head;
        while(cur.getNextNode()!=null){
            if(!set.add(cur.getNodeData())){
                Node nextNode=cur.getNextNode();
                cur.setNodeData(nextNode.getNodeData());
                cur.setNextNode(nextNode.getNextNode());
            }else {
                cur=cur.getNextNode();

            }
        }
        Node pre=head;
        if(!set.add(cur.getNodeData())){
            while(pre.getNextNode()!=cur){
                pre=pre.getNextNode();
            }
            pre.setNextNode(null);
        }
    }
    public void deleteDuplicateNode02(){
        if(head==null&head.getNextNode()==null){
            return;
        }
        Node p=head;
        Node q=head.getNextNode();
        while(q!=null){
            if(q.getNextNode()!=null&&q.getNextNode().getNodeData()==q.getNodeData()){
                while(q.getNextNode()!=null&&q.getNextNode().getNodeData()==q.getNodeData()) {
                    q = q.getNextNode();
                }
            }
            p.setNextNode(q.getNextNode());
            q=q.getNextNode();
        }
    }
    public  Node theLastKNode(int k){
        if(k<0){
            return null;
        }
        Node n=head;
        while(n!=null&&k!=0){
            n=n.getNextNode();
            k--;
        }
        if(k!=0){
            return null;
        }
        Node cur=head;
        while(n!=null){
            cur=cur.getNextNode();
            n=n.getNextNode();
        }
        return cur;
    }
    public static void main(String[] args) {
        int[] a={1,2,2,3,3,4,4,4,5};
        MyLinkedList list=new MyLinkedList(a);
        list.printList();
        System.out.println();
        Node node=list.theLastKNode(4);
        System.out.println(node.getNodeData());
        list.deleteDuplicateNode02();
        System.out.println();
        list.printList();
    }

}
class Node{
    private int data;
    private Node next;
    public Node(){}
    public Node(int data){
        this.data=data;
    }
    public Node getNextNode(){
        return this.next;
    }
    public void setNextNode(Node node){
        this.next=node;
    }
    public int getNodeData(){
        return this.data;
    }
    public void setNodeData(int val){
        this.data=val;
    }

}
