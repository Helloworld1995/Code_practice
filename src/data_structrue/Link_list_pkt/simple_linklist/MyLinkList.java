package data_structrue.Link_list_pkt.simple_linklist;

import java.util.*;

public class MyLinkList {
    Node head=null;
    int size=0;
    public void addNode(Node node){
        if(head==null){
            head=node;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        size++;
    }
    public boolean deleteNode(int index){
        if(index<1||index>size){
            return false;
        }
        if(index==1){
            head=head.next;
            size--;
            return true;
        }
        int i=2;
        Node preNode=head;
        Node curNode=preNode.next;
        while(curNode!=null){
            if(index==i){
                preNode.next=curNode.next;
                size--;
                return true;
            }
            preNode=preNode.next;
            curNode=curNode.next;
            i++;
        }
        return false;
    }
    public int length(){
        Node temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        return len;
    }
    /**
     * 对链表进行排序(*)
     */
    public Node orderList(){
        Node nextNode=null;
        int temp=0;
        Node curNode=head;
        while(curNode.next!=null){
            nextNode=curNode.next;
            while(nextNode!=null){
                if(curNode.data>nextNode.data){
                    temp=curNode.data;
                    curNode.data=nextNode.data;
                    nextNode.data=temp;
                }
                nextNode=nextNode.next;
            }
            curNode=curNode.next;
        }

        return head;
    }
    public void printLoopList(){
        System.out.println();
        Node temp=head;
        int len=size+2;
        while(temp!=null){
            if(len==0){
                break;
            }
            System.out.print(temp.data+"--->");
            temp=temp.next;
            len--;
        }
    }
    public void printList(){
        System.out.println();
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"--->");
            temp=temp.next;
        }
    }
    public boolean insert(Node node,int index){
        int i=1;
        if(index<1||index>size){
            throw new RuntimeException("error!");
        }
        Node preNode=head;
        Node curNode=preNode.next;
        while(curNode!=null){
            if(i==index){
                preNode.next=node;
                node.next=curNode;
                size++;
                return true;
            }
            preNode=preNode.next;
            curNode=curNode.next;
            i++;
        }
        return false;
    }

    public int loopLength(){
        if(!findLoopOfLink()){
            return 0;
        }
        int steps=0;
        Node fast=head;
        Node slow=head;
        boolean firstMeet=false;
        boolean secondMeet=false;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(secondMeet==true&&fast==slow){
                break;
            }
            if(firstMeet==true){
                steps++;
            }
            if(secondMeet==false&&fast==slow){
                firstMeet=true;
                secondMeet=true;
            }

        }
        return steps;
    }

    public void delDuplecate(){
        HashSet<Integer> set=new HashSet<>();
        Node temp=head;
        Node pre=null;
        while(temp!=null) {
            if (set.contains(temp.data)) {
                pre.next = temp.next;
                size--;
            }else {
                set.add(temp.data);
                pre = temp;
            }
            temp=temp.next;
        }
    }
    public void delDuplecate2(){
        Node p=head;
        while(p.next!=null){
           Node q=p;
            while(q.next!=null){
                if(p.data==q.next.data){
                    q.next=q.next.next;
                }else{
                    q=q.next;
                }
            }
            p=p.next;
        }
    }

    /**
     * 找出单链表中倒数第k个节点
     * @param k
     */
    public Node finElement(int k){
        if(k<1){
            return null;
        }
        int i=0;
        Node p1=head;
        Node p2=head;
        while(p2!=null&&i<k-1){
            i++;
            p2=p2.next;
            if(p2==null){
                throw new RuntimeException("k不合法");
            }
        }
        while(p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }

    /**
     * 反转打印链表
     * @param pListHead
     */
    public void printListReversely(Node pListHead){
        if(pListHead!=null){
            printListReversely(pListHead.next);
            System.out.println(pListHead.data);
        }
    }

    /**
     * 运用栈反转打印链表
     */
    public void printListReversely2(){
        Node temp=head;
        Stack<Node> stack=new Stack<>();
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        int len=stack.size();
        for (int i = 0; i <len ; i++) {
            System.out.print(stack.pop().data+",");

        }
    }

    /**
     * 链表反转
     */
    public void reverseLink(){
        if(head==null||head.next==null){
            throw new RuntimeException("error accured!");
        }
        Node preNode=null;
        Node curNode=head;
        Node nextNode=null;
        while(curNode!=null){
            nextNode=curNode.next;
            curNode.next=preNode;
            preNode=curNode;
            curNode=nextNode;
        }
        head=preNode;
    }

    /**
     * use stack to reverse linklist
     */
   public void reverse2(){
        Node node=head;
        Stack<Node> stack=new Stack<>();
        while(node!=null){
            stack.push(node);
            node=node.next;
        }
       if(!stack.isEmpty()){
           head=stack.pop();
       }
       Node cur=head;
       while(!stack.isEmpty()){
           Node temp=stack.pop();
           temp.next=null;//当前出栈节点的引用必须是空，才能保证单项链表
           cur.next=temp;//当前节点的下一个节点是当前出栈节点
           cur=temp;//当前节点后移为下一个节点
       }

   }

    /**
     * 寻找链表中间节点
     * @return
     */
    public Node findMiddleNode() {
        Node slow=head;
        Node fast=head;
        List<Node> nodelist=new ArrayList<>(2);
        int count=0;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            count+=2;
            slow=slow.next;
        }

        return slow;
    }

    /**
     * 寻找中间节点
     * @return
     */
    public List<Node> findMidNodes(){
        List<Node> nodelist=new ArrayList<>();
        int len=this.length();
        boolean flag=false;
        int mid=len/2;
        if(len%2==0){
            flag=true;
        }
        int count=1;
        Node node=head;
        while(node.next!=null&&count<=mid){
            node=node.next;
            count++;
        }
        nodelist.add(node);
        if(flag){
            nodelist.add(node.next);
        }
        return nodelist;
    }

    /**
     * 判断链表是否有环
     * @return
     */
    public boolean findLoopOfLink(){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 利用set判断是否有环，并找到环入口
     * @return
     */
    public boolean findLoop2(){
        Set<Node> set=new HashSet<>();
        Node node =head;
        if(node==null&&node.next==null){
            return false;
        }
        set.add(node);
        while(node.next!=null){
            node=node.next;
            if(!set.add(node)){
                System.out.println("loop gate is "+node.data);
                return true;
            }
        }
        return false;
    }

    /**
     * 设置链表为循环链表（环）
     */
    public void buildLoop(){
        Node node=head;
        while(node.next!=null){
            node=node.next;
        }
        node.next=head;
    }

    /**
     * 不知道头节点的情况下删除中间节点
     * @param node
     * @return
     */
    public boolean deleteNodeunknownHead(Node node){
        if(node==null&&node.next==null){
            return false;
        }
        node.data=node.next.data;
        node.next=node.next.next;
        return true;
    }

    /**
     * 判断两个链表是否相交
     * @param n1
     * @param n2
     * @return
     */
    public boolean isIntersect(Node n1,Node n2){
        if(n1==null||n2==null){
            return false;
        }
        Node tail1=n1;
        Node tail2=n2;
        while(tail1.next!=null){
            tail1=tail1.next;
        }
        while(tail2.next!=null){
            tail2=tail2.next;
        }
        if(tail1==tail2){
            return true;
        }
        return false;
    }
    public Node swapPairs(Node head) {
        if(head==null||head.next==null){
            return head;
        }
        Node pre=new Node(-1);
        pre.next=head;
        Node temp=pre;
        while(temp.next!=null&&temp.next.next!=null){
            Node left=temp.next;
            Node right=temp.next.next;
            temp.next=right;
            left.next=right.next;
            right.next=left;
            temp=left;
        }
        return pre.next;
    }

    /**
     * 找到两个链表相交的第一个节点
     * @param n1
     * @param n2
     * @return
     */
    public Node getFirstMeetNodeOf2Links(Node n1,Node n2){
        if(n1==null||n2==null){
            return null;
        }
        Node tail1=n1;
        Node tail2=n2;
        int len1=1;
        int len2=1;
        while(tail1.next!=null){
            tail1=tail1.next;
            len1++;
        }
        while(tail2.next!=null){
            tail2=tail2.next;
            len2++;
        }
        if(tail1!=tail2){
            return null;
        }
        if(len1>len2){
            int d=len1-len2;
            while(d!=0){
                tail1=tail1.next;
                d--;
            }
        }else{
            int d=len2-len1;
            while(d!=0){
                tail2=tail2.next;
                d--;
            }
        }
        while(tail1!=tail2){
            tail1=tail1.next;
            tail2=tail2.next;
        }
        return tail1;
    }
    public static void main(String[] args) {
        MyLinkList list=new MyLinkList();
        for (int i = 1; i <=4; i++) {
            list.addNode(new Node(i));
        }
        list.swapPairs(list.head);
        list.printList();
        /*System.out.println(list.size);
//        list.buildLoop();
        boolean flag = list.findLoop2();
        System.out.println(flag);
        int len=list.loopLength();
        System.out.println(len);
        list.printLoopList();
        list.printListReversely(list.head);*/
//        list.printList();
//        list.deleteNode(99);
//        list.deleteNode(98);
//        list.deleteNode(97);
//        list.deleteNode(90);
//        System.out.println();
//        list.printList();
//        System.out.println();
//        System.out.println(list.size);
//        list.insert(new Node(10086),5);
//        System.out.println();
//        list.printList();
//        list.delDuplecate();
//        System.out.println();
//        list.printList();
//        System.out.println();
//        System.out.println(list.finElement(5).data);
//        list.printListReversely2();
//        System.out.println();
//        list.reverseLink();
//        list.printList();
//        System.out.println();
//        Node node = list.findMiddleNode();
//        System.out.println(node.data);
//        list.buildLoop();
//        System.out.println();
//        System.out.println(list.findLoopOfLink());
//        list.findLoop2();
    }
}
