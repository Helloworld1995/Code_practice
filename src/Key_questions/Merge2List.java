package Key_questions;

public class Merge2List {
    public static void main(String[] args) {
        Merge2List ml = new Merge2List();
        int[] a1 = {1, 3, 5};
        int[] a2 = {2, 4, 6,8};
        MyLinkedList list1 = new MyLinkedList(a1);
        MyLinkedList list2 = new MyLinkedList(a2);
        Node phead=ml.merge(list1.head,list2.head);
//        MyLinkedList list = ml.mergeList(list1, list2);
        while(phead!=null){
            System.out.print(phead.getNodeData()+"->");
            phead=phead.getNextNode();
        }

    }

    public MyLinkedList mergeList(MyLinkedList list1, MyLinkedList list2) {
        MyLinkedList list = new MyLinkedList();
        Node n1=list1.head;
        Node n2=list2.head;
        if(n1.getNodeData()<=n2.getNodeData()){
            list.insert(n1);
            n1=n1.getNextNode();
        }else{
            list.insert(n2);
            n2=n2.getNextNode();
        }
        Node n = list.head;
        while (n1 != null && n2 != null) {
            if (n1.getNodeData() <=n2.getNodeData()) {
                if(n==null){
                    n=n1;
                }else {
                    n.setNextNode(n1);
                }
                n1 = n1.getNextNode();
            } else{
                if(n==null){
                    n=n2;
                }else {
                    n.setNextNode(n2);
                }
                n2 = n2.getNextNode();
            }
            n=n.getNextNode();
        }
            if (n1 != null) {
                n.setNextNode(n1);
            }
            if (n2 != null) {
                n.setNextNode(n2);
            }
            return list;

        }
    public Node merge(Node n1,Node n2){
        if(n1==null){
            return n2;
        }
        if(n2==null){
            return n1;
        }
        if(n1.getNodeData()<=n2.getNodeData()){
            n1.setNextNode(merge(n1.getNextNode(),n2));
            return n1;
        }else{
            n2.setNextNode(merge(n1,n2.getNextNode()));
            return n2;
        }
    }
}

