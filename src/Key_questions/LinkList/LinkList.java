package Key_questions.LinkList;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.List;

public class LinkList {
    Node head=null;
    int size=0;
    public void insert(int data){
        Node temp=new Node(data);
        if(head==null){
            head=temp;
            size++;
            return;
        }
        Node n=head;
        while(n.next!=null){
            n=n.next;
        }
        n.next=temp;
        size++;
    }
    private void printList(){
        Node n=head;
        while(n!=null){
            System.out.print(n.data+"-->");
            n=n.next;
        }
        System.out.println();
    }
    private void mergeList(LinkList list1,LinkList list2){
        Node n=list1.head;
        Node n1=list2.head;
        if(head==null){
            if(n.data>n1.data){
                head=list2.head;
                n1=n1.next;
            }else{
                head=list1.head;
                n=n.next;
            }
        }
        Node newNode=head;
        while(n!=null&&n1!=null){
            if(n.data>n1.data){
                newNode.next=n1;
                n1=n1.next;
            }else{
                newNode.next=n;
                n=n.next;
            }
            newNode=newNode.next;
        }
        if(n!=null){
            newNode.next=n;
        }
        if(n1!=null){
            newNode.next=n1;
        }
    }
    private void sort(){
        if(head==null||head.next==null){
            return;
        }
        Node n=head;
        Node n1=head.next;
        while(n1!=null){

        }
    }
    private Node mergeList2(Node head1,Node head2){
        if(head1==null&&head2==null){
            return null;
        }
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        if(head1.data<head2.data){
            head1.next=mergeList2(head1.next,head2);
            return head1;
        }else{
            head2.next=mergeList2(head1,head2.next);
            return head2;
        }
    }
    private void print(Node node){
        while(node!=null){
            System.out.print(node+"->");
            node=node.next;
        }
    }
    private LinkList mergeKSortedList(ArrayList<LinkList> lists){
        LinkList listX = CreateList.mergeList(lists.get(0), lists.get(1));
        for (int i = 2; i <lists.size() ; i++) {
            LinkList list = lists.get(i);
            listX = CreateList.mergeList(listX, list);
        }
        return listX;
    }
    private void splitListByOneNumber(LinkList list,int index){
        Node n=list.head;
        if(n.data<index){
            head=n;
        }
        n=n.next;
        Node node=head;
        while(n!=null){
            if(n.data<=index){
                node.next=n;
                node=node.next;
            }
            n=n.next;
        }
        n=list.head;
        while(n!=null){
            if(n.data>index){
                node.next=n;
                node=node.next;
            }
            n=n.next;
        }
    }
    public Node reverseBetween(Node head, int m, int n) {
        int index=1;
        Node header=new Node(-1);
        header.next=head;
        Node node=header;
        while(node!=null) {
            if (index == m) {
                Node first = node;
                Node second = node.next;
                Node last = null;
                Node pre = node;
                Node cur = node.next;
                while (true) {
                    Node temp = cur.next;
                    cur.next = pre;
                    pre = cur;
                    if (index == n) {
                        last = temp;
                        break;
                    }
                    cur = temp;
                    index++;
                }
                first.next = cur;
                second.next = last;
                break;
            } else {
                index++;
                node= node.next;
            }
        }
        return header.next;
    }


    public static void main(String[] args) {
        int[] a1={1,3,4,8,9};
        int[] a2={5,3};
        int[] a3={0,1,15,16,17,18};
        int[] a4={7,8,9,12,15,16};
        int[] a5={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

        LinkList list1 = CreateList.createList(a1);
        LinkList list2 = CreateList.createList(a2);
        list2.reverseBetween(list2.head,1,2);
        list2.printList();

        LinkList list3=CreateList.createList(a3);
        LinkList list4=CreateList.createList(a4);
        LinkList list5=CreateList.createList(a5);

//        l.splitListByOneNumber(list3, 16);
//        l.printList();
        ArrayList<Node> heads=new ArrayList<>();
        heads.add(list1.head);
        heads.add(list2.head);
        Node hhhh = CreateList.mergekSortedList(heads);
        CreateList.printNodes(hhhh);
        Node hhh = CreateList.reverseEveryK(list5.head, 3);
        CreateList.printNodeExceptFirstLead(hhh);
        Node hh = CreateList.reverseLinkListSegment(list5.head, 5, 10);
        CreateList.printNodes(hh);
        Node h1 = CreateList.reverseList(list4.head);
        CreateList.printNodes(h1);
        Node h = CreateList.mergeList01(list1, list2);
        CreateList.printNodes(h);
        Node node = CreateList.splitListByOneNumber(list3, 16);
        CreateList.printNodes(node);

        Node head = CreateList.oddEvenList(list4);
        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
        ArrayList<LinkList> list=new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        LinkList llist=new LinkList();
        LinkList listx = llist.mergeKSortedList(list);
        listx.printList();
//        System.out.println();
//        list.mergeList(list1,list2);
//        list.printList();
        System.out.println();
//        LinkList mergeList = CreateList.mergeList(list1, list2);
//        mergeList.printList();
//        System.out.println();

    }
}
class Node{
    Node next;
    int data;
    public Node(int data){
        this.data=data;
    }
    public String toString(){
        return ""+this.data;
    }
}
class CreateList{
    public static LinkList createList(int[] a){
        LinkList list=new LinkList();
        for (int i : a) {
            list.insert(i);
        }
        return list;
    }
    public static LinkList createList(){
        return new LinkList();
    }
    public static Node mergeList01(LinkList list1,LinkList list2){
        Node head1=list1.head;
        Node head2 = list2.head;
        Node n=null;
        if(head1.data<head2.data){
            n=head1;
            head1=head1.next;
        }else{
            n=head2;
            head2=head2.next;
        }

        while(head1!=null&&head2!=null){
            if(head1.data<head2.data){
                n.next=head1;
                head1=head1.next;
            }else{
                n.next=head2;
                head2=head2.next;
            }
            n=n.next;
        }
        if(head1!=null){
            n.next=head1;
        }
        if(head2!=null){
            n.next=head2;
        }
        return list1.head;
    }
    public static Node mergekSortedList(ArrayList<Node> heads){
        Node header=null;
        Node head=new Node(-1);
        int min=Integer.MAX_VALUE;
        int index=0;
        int count=0;
        Node firstNode=null;
        for (int i = 0; i <heads.size() ; i++) {
            Node node=heads.get(i);
            if(min>node.data){
                min=node.data;
                firstNode=node;
                header=node;
                node=node.next;
                heads.remove(i);
                heads.add(i,node);
            }
        }
        head.next=firstNode;
        head=head.next;
        while(true){
            if(count==heads.size()){
                break;
            }
            min=Integer.MAX_VALUE;
            for (int i = 0; i <heads.size() ; i++) {
                Node node = heads.get(i);
                if (node != null && node.data < min) {
                    min = node.data;
                    firstNode = node;
                    index = i;
                }else if(node==null){
                    count++;
                }
            }
            head.next=firstNode;
            head=head.next;
            heads.remove(index);
            heads.add(index,firstNode.next);
        }
        return header;

    }
    public static LinkList mergeList(LinkList list1,LinkList list2){
        LinkList newList=new LinkList();
        if(list1==null&&list2==null){
            return null;
        }
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        Node n=list1.head;
        Node n1=list2.head;
        if(n.data>n1.data){
            newList.head=n1;
            n1=n1.next;
        }else{
            newList.head=n;
            n=n.next;
        }
        Node newNode=newList.head;
        while(n!=null&&n1!=null){
            if(n.data>n1.data){
                newNode.next=n1;
                n1=n1.next;
            }else{
                newNode.next=n;
                n=n.next;
            }
            newNode=newNode.next;
        }
        if(n!=null){
            newNode.next=n;
        }
       if(n1!=null){
            newNode.next=n1;
        }
        return newList;
    }
    public static Node splitListByOneNumber(LinkList list,int index){
        Node head=list.head;
        Node n=head;
        Node left=null;
        Node right=null;
        Node tempr=null;
        Node templ=null;
        while(n!=null) {
            if (n.data <= index) {
                left = n;
                templ=left;
                break;
            }
            n=n.next;
        }
        n=head;
        while(n!=null){
            if(n.data>index){
                right=n;
                tempr=right;
                break;
            }
            n=n.next;
        }
        n=head;
        while(n!=null){
            if(n.data<=index&&templ!=n){
                left.next=n;
                left=left.next;
            }else if(n.data>index&&tempr!=n){
                right.next=n;
                right=right.next;
            }
            n=n.next;
        }
        left.next=tempr;
        return head;
    }
    public static Node oddEvenList(LinkList list){
        Node head=list.head;
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        Node temp=head.next;
        Node odd=head;
        Node even=head.next;
        while(even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=temp;
        return head;
    }
    public static void printNodes(Node node){
        while(node!=null){
            System.out.print(node.data+"->");
            node=node.next;
        }
        System.out.println();
    }
    public static void printNodeExceptFirstLead(Node node){
        node=node.next;
        while(node!=null){
            System.out.print(node.data+"->");
            node=node.next;
        }
    }

    /**
     * 链表反转(三个指针)
     * @param head
     * @return
     */
    public static Node reverseList(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node pre=null;
        Node cur=head;
        Node behind=head.next;
        while(behind!=null){
            cur.next=pre;
            pre=cur;
            cur=behind;
            behind=behind.next;
        }
        cur.next=pre;
        return cur;
    }

    /**
     * 链表反转(两个指针）
     * @param head
     * @return
     */

    public static Node reverseList2(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node pre=null;
        Node cur=head;
        while(cur!=null){
            Node temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return cur;
    }

    /**
     * 链表制定某一段反转
     * @param
     */
    public static Node reverseLinkListSegment(Node head,int start,int end){
        if(head==null||head.next==null){
            return head;
        }
        Node header=head;
        Node startNodePre=header;
        Node endNode=header;
        int index=0;
        while(head!=null){
            if(index+1==start){
                startNodePre=head;
                break;
            }
            index++;
            head=head.next;
        }
        while(head!=null){
            if(index==end){
                endNode=head;
                break;
            }
            index++;
            head=head.next;
        }

        Node startNode=startNodePre.next;
        Node endNext=endNode.next;
        Node pre=startNode;
        Node cur=pre.next;
        while(true){
            Node temp=cur.next;
            cur.next=pre;
            if(cur==endNode){
                break;
            }
            pre=cur;
            cur=temp;
        }
        startNode.next=endNext;
        startNodePre.next=cur;

        return header;
    }

    /**
     * 每K个节点反转链表
     * @param head
     * @param k
     * @return
     */
    public static Node reverseEveryK(Node head,int k){
        Node header=new Node(-1);
        header.next=head;
        Node preP=header;
        if(head==null||k<1){
            return null;
        }
        Node q=head;
        Node p=head;
        Node temp=null;
        int index=1;
        while(q!=null){
            if(index==k){
                Node qnext=q.next;
                preP.next=q;
                reverseList(p,q);
                preP=p;
                p=qnext;
                q=qnext;
                index=1;
            }
            temp=q;
            q=q.next;
            index++;
        }
        preP.next=temp;
        return header;
    }
    public static void reverseList(Node start,Node end){
        Node p=start;
        Node q=end;
        Node pre=p;
        Node cur=pre.next;
        while(cur!=null){
            Node temp=cur.next;
            cur.next=pre;
            if(cur==end){
                break;
            }
            pre=cur;
            cur=temp;
        }
    }

}