package data_structrue.Tree;

import java.util.*;

/**
 * 二叉查找树（二叉排序树）
 * 左孩子节点数据小于父节点数据，右孩子节点数据大于等于父节点数据
 */
public class BinaryTree {
    private int maxLen=0;
    private Node root;
    public BinaryTree(){
        root=null;
    }
    public void insert(int data){
        Node newNode=new Node(data);
        if(root==null){
            root=newNode;
        }else{
            Node current=root;
            Node parent;
            while(true){
                parent=current;
                if(data<current.data){
                    current=current.left;
                    if(current==null){
                        parent.left=newNode;
                        return;
                    }
                }else{
                    current=current.right;
                    if(current==null){
                        parent.right=newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 中序遍历递归实现
     * @param lc
     */
    public void inOrder(Node lc){
        if(lc!=null) {
            inOrder(lc.left);
            System.out.print(lc.data + " ");
            inOrder(lc.right);
        }
    }
    public void preOrder(Node lc){
        if(lc!=null){
            System.out.print(lc.data+" ");
            preOrder(lc.left);
            preOrder(lc.right);
        }
    }
    public void postOrder(Node lc){
        if(lc!=null){
            postOrder(lc.left);
            postOrder(lc.right);
            System.out.print(lc.data+" ");
        }
    }
    public void inOrder(){
        System.out.print("中序遍历递归实现：");
        inOrder(this.root);
    }
    public void preOrder(){
        System.out.print("前序遍历递归实现：");
        preOrder(this.root);
    }
    public void postOrder(){
        System.out.print("后序遍历递归实现：");
        postOrder(this.root);
    }
    public void layerTranverse(){
        if(this.root==null){
            return;
        }
        System.out.print("层次遍历：");
       Queue<Node> q=new LinkedList<>();
        q.add(this.root);
        while(!q.isEmpty()){
            Node n=q.poll();
            System.out.print(n.data+" ");
            if(n.left!=null){
                q.add(n.left);
            }
            if(n.right!=null){
                q.add(n.right);
            }
        }
    }

    public void buildTree(int[] data){
        for (int d : data) {
            insert(d);
        }
    }
    public void preOrder02(){
        System.out.print("前序遍历非递归实现:");
       Node p=root;
        Stack<Node> s = new Stack<>();
       while(p!=null||s.size()>0){
           if(p!=null){
               System.out.print(p.data+" ");
               s.push(p);
               p=p.left;
           }else{
               Node tem=s.pop();
               p=tem.right;
           }
       }
    }
    public void inOrder02() {
        System.out.print("中序遍历非递归实现:");
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                Node tem = stack.pop();
                System.out.print(tem.data+" ");
                node = tem.right;
            }
        }
    }
    public int getMaxDeep(Node node){
        if(node==null){
            return 0;
        }else{
            int left=getMaxDeep(node.left);
            int right=getMaxDeep(node.right);
            return 1+Math.max(left,right);
        }

    }
    public int getMaxWidth(Node node){
        if(node==null){
            return 0;
        }
        Queue<Node> q=new LinkedList<>();
        int maxWidth=-1;
        q.add(root);
        while(!q.isEmpty()){
            Node n=q.poll();
            if(n.left!=null) {
                q.add(n.left);
            }
            if(n.right!=null) {
                q.add(n.right);
            }
            if(maxWidth<q.size()){
                maxWidth=q.size();
            }
        }
        return maxWidth;
    }

    public int max(int a,int b){
        return a>b?a:b;
    }


   public void findMaxDistance(Node root) {
       if (root == null) {
           return;
       }
       if (root.left == null) {
           root.leftMaxDistance = 0;
       }
       if (root.right == null) {
           root.rightMaxDistance = 0;
       }
       if (root.left != null) {
           findMaxDistance(root.left);
           root.leftMaxDistance = max(root.left.leftMaxDistance, root.left.rightMaxDistance)+1;
       }
       if (root.right != null) {
           findMaxDistance(root.right);
           root.rightMaxDistance = max(root.right.leftMaxDistance, root.right.rightMaxDistance)+1;
       }
//       if (root.left != null) {
//           root.leftMaxDistance = max(root.left.leftMaxDistance, root.left.rightMaxDistance)+1;
//       }
//       if (root.right != null) {
//           root.rightMaxDistance = max(root.right.leftMaxDistance, root.right.rightMaxDistance)+1;
//       }
       if (root.leftMaxDistance+root.rightMaxDistance>maxLen) {
            maxLen=root.leftMaxDistance+root.rightMaxDistance;
       }
   }


    public static void main(String[] args) {
        BinaryTree btree=new BinaryTree();
        int[] data={6,8,5,9,7,6,4};
        btree.buildTree(data);
        btree.inOrder();
        System.out.println();
        btree.preOrder();
        System.out.println();
        btree.postOrder();
        System.out.println();
        btree.layerTranverse();
        System.out.println();
        btree.preOrder02();
        System.out.println();
        btree.inOrder02();
        btree.findMaxDistance(btree.root);
        System.out.println();
        System.out.println("树的最大路径"+btree.maxLen);
        System.out.println("树的最大深度"+btree.getMaxDeep(btree.root));
        System.out.println("树的最大宽度"+btree.getMaxWidth(btree.root));
    }
}
