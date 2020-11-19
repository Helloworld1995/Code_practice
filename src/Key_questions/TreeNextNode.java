package Key_questions;


import Key_questions.TreeStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 中序遍历顺序的下一个节点：倘若该节点有右节点，则下一节点是右节点一直找到左节点到叶节点。
 * 否则为第一个左上连接指向的节点的祖先节点。
 * 同时，树不光包含左右指针，还包括指向父节点的指针。
 */
public class TreeNextNode {
    static boolean isBalance=true;
    TreeNode root;
    int size=0;
    public TreeNextNode(){
        this.root=null;
    }
    public void insert(int data){
        TreeNode node=new TreeNode(data);
        size++;
        if(root==null){
            root=node;
            node.next=null;
        }else{
            TreeNode currentNode=root;
            TreeNode parent;
            while(true){
                parent=currentNode;
                if(data<currentNode.data){
                    currentNode=currentNode.left;
                    if(currentNode==null) {
                        parent.left = node;
                        node.next=parent;
                        return;
                    }
                }else{
                    currentNode=currentNode.right;
                    if(currentNode==null){
                        parent.right=node;
                        node.next=parent;
                        return;
                    }
                }
            }
        }
    }
    public void preOrder(TreeNode node){
        if(node!=null){
            if(node==root){
                System.out.print(node.data+"->"+"null,");
            }else {
                System.out.print(node.data + "->" + node.next.data + ",");
            }
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void postOrder(TreeNode node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data+",");
        }
    }
    public TreeNode findKstNode(int k){
        TreeNode tnode=root;
        if(tnode==null){
            return null;
        }
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||tnode!=null){
            if(tnode!=null){
                stack.push(tnode);
                tnode=tnode.left;
            }else{
                TreeNode temp=stack.pop();
                if(k<=0){
                    return temp;
                }else{
                    tnode=temp.right;
                    k--;
                }
            }
        }
    return null;
    }
    public void preOrder01(){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack= new Stack<>();
        TreeNode node=root;
        while(node!=null||!stack.isEmpty()){
            if(node!=null){
                System.out.print(node.data+",");
                stack.push(node);
                node=node.left;
            }else{
                node=stack.pop().right;
            }
        }
    }
    public void inOrder01(){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack= new Stack<>();
        TreeNode node=root;
        while(node!=null||!stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                TreeNode temp=stack.pop();
                System.out.print(temp.data+",");
                node=temp.right;
            }
        }
    }
    public void layerOrder(){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        TreeNode node=root;
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            System.out.print(temp.data+",");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }
    public int theTreeDeep(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftdeep=theTreeDeep(root.left);
        int rightdeep=theTreeDeep(root.right);
        return Math.max(leftdeep,rightdeep)+1;
    }

    /**
     * 找到中序遍历顺序下的下一个节点
     */
    public TreeNode findNextNodeIn(TreeNode node){
        if(node==null){
            return null;
        }
        if(node.right!=null){
            TreeNode pnode=node.right;
                while (pnode.left != null) {
                    pnode = pnode.left;
                }
                return pnode;
            }else{
                while(node.next!=null){
                    TreeNode parent=node.next;
                    if(parent.left==node){
                        return parent;
                }
                    node=node.next;
            }
        }
        return null;
    }

    /**
     * 二叉树的镜像非递归实现
     */
    public void mirrorOfTree(){
        TreeNode node=root;
        if(node==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode n=queue.poll();
            TreeNode leftChild = n.left;
            TreeNode rightChild=n.right;
            n.right=leftChild;
            n.left=rightChild;
            if(leftChild!=null) {
                queue.add(leftChild);
            }
            if(rightChild!=null){
                queue.add(rightChild);
            }
        }
    }

    /**
     * 二叉树镜像递归实现
     */
    public void mirrorOfTree01(TreeNode node){
        if(node==null){
            return;
        }
        TreeNode leftChild=node.left;
        TreeNode rightChild=node.right;
        TreeNode temp=leftChild;
        leftChild=rightChild;
        rightChild=temp;
        mirrorOfTree01(rightChild);
        mirrorOfTree01(leftChild);
    }

    public TreeNode getLeftChild(){
        if(root==null){
            return null;
        }
        TreeNode node=root;
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }

    public TreeNode findNearestFatherNode(TreeNode root,TreeNode p,TreeNode q){
        /**
         * 寻找p,q最低父节点，这是二分查找树的做法
          */
        if(root==null){
            return null;
        }
        if(root.data>p.data&&root.data>q.data){
            findNearestFatherNode(root.left,p,q);
        }
        if(root.data<p.data&&root.data<q.data){
            findNearestFatherNode(root.right,p,q);
        }
        return root;
    }

    public TreeNode findNearestFatherNode02(TreeNode root,TreeNode p,TreeNode q) {
        /**
         * 寻找p,q最低父节点，这是普通二叉树的做法
         *
         */
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left=findNearestFatherNode02(root.left, p, q);
        TreeNode right=findNearestFatherNode02(root.right, p, q);
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;
    }

    public TreeNode mergeTree(TreeNode root1,TreeNode root2){
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        TreeNode root=new TreeNode(root1.data+root2.data);
        root.left=mergeTree(root1.left,root2.left);
        root.right=mergeTree(root1.right,root2.right);
        return root;
    }

    /**
     * 找到先序遍历顺序的下一个节点
     * @param node
     * @return
     */
    public TreeNode findNextNodePre(TreeNode node){
        if(node==null){
            return null;
        }
        TreeNode pnode=null;
        if(node.left!=null){
            pnode=node.left;
            return pnode;
        }else if(node.right!=null){
            pnode=node.right;
            return pnode;
        }else{
            while(node.next!=null){
                pnode=node;
                node=node.next;
            }
            if(node.left==pnode){
                return node.right;
            }else if(node.right==pnode){
                return null;
            }
        }
        return null;
    }
    public boolean isBalancedTree(TreeNode root){
        int maxdeep = checkIfBalance(root);
        return isBalance;
    }
    public int checkIfBalance(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=checkIfBalance(root.left);
        int right=checkIfBalance(root.right);
        if(Math.abs(left-right)>1){
            isBalance=false;
        }
        return Math.max(left,right)+1;
    }


    public static void main(String[] args) {
        TreeNextNode tree=new TreeNextNode();
        int[] data={6,8,5,9,7,10,4};
        for (int d : data) {
            tree.insert(d);
        }
        System.out.println("第4大的节点"+tree.findKstNode(4).data);
        System.out.println("二叉树最大深度"+tree.theTreeDeep(tree.root));
        System.out.println("是否是平衡二叉树(任意节点的左右子树高度不大于1) true or false ? "+tree.isBalancedTree(tree.root));
        tree.preOrder(tree.root);
        System.out.println();
        tree.preOrder01();
        System.out.println();
        tree.inOrder01();
        System.out.println();
        tree.layerOrder();
        TreeNode nextNode=tree.findNextNodeIn(tree.root);
        System.out.println();
        System.out.println("中序遍历下一个节点为"+nextNode.data);
        TreeNode left=tree.getLeftChild();
        System.out.println(left.data);
        TreeNode nextNode1=tree.findNextNodePre(left);
        System.out.println();
        System.out.println("前序遍历下一个节点为"+nextNode1.data);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
        tree.mirrorOfTree01(tree.root);
        tree.layerOrder();
    }
}
