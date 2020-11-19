package Key_questions;

/**
 * O(1)复杂度删除一个节点
 */
public class DeleteNode {
    public static void main(String[] args) {
        int[] ininital={1,2,3,4,5,6,7,8,9};
        MyLinkedList list=new MyLinkedList(ininital);
        DeleteNode deleteNode=new DeleteNode();
        deleteNode.deleteNode(list,new Node(8));
    }
    private Node deleteNode(MyLinkedList list,Node node){
        if(list.head==null||node==null){
            return null;
        }
        if(node.getNextNode()!=null){
            Node nextNode=node.getNextNode();
            node.setNodeData(nextNode.getNodeData());
            node.setNextNode(nextNode.getNextNode());
        }else if(list.head==node){
            list.head=null;
        }else{
            Node cur=list.head;
            while(cur.getNextNode()!=node){
                cur=cur.getNextNode();
            }
            cur=null;
        }
        return list.head;
    }
}
