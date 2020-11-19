package data_structrue.Link_list_pkt.Queue.LinkQueue;

import data_structrue.Link_list_pkt.Queue.Node;

public class LinkQueue<E> {
    Node<E> head=null;
    Node<E> tail=null;
    public boolean isEmpty(){
        return head==tail;
    }
    public void put(E data){
        Node<E> newNode=new Node(data);
        if(head==null&&tail==null){
            head=tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
    }
    public E pop(){
        if(isEmpty()){
            return null;
        }
        E data=head.data;
        head=head.next;
        return data;
    }
    public int size(){
        int count=0;
        Node<E> temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LinkQueue<Integer> queue=new LinkQueue<>();
        for (int i = 0; i <100 ; i++) {
            queue.put(i);
        }
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.size());
    }
}
