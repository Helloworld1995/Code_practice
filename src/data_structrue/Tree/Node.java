package data_structrue.Tree;

public class Node {
    public int data;
    public Node left;
    public Node right;
    public int leftMaxDistance;
    public int rightMaxDistance;
    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
