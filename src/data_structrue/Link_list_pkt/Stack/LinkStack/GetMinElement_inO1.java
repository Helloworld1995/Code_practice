package data_structrue.Link_list_pkt.Stack.LinkStack;

import java.util.Random;

/**
 * O(1)复杂度获取栈中最小元素
 */
public class GetMinElement_inO1 {
    LinkStack elem;
    LinkStack min;
    LinkStack max;
    public GetMinElement_inO1(){
        elem=new LinkStack();
        min=new LinkStack();
        max=new LinkStack();
    }
    public void push(Node newNode){
        Integer data= newNode.data;
        elem.push(newNode);
        elem.size++;
        if(min.isEmpty()){
            min.push(newNode);
            min.size++;
        }
        if(min.peek()> data){
            min.push(newNode);
            min.size++;
        }
        if(max.isEmpty()){
            max.push(newNode);
            max.size++;
        }
        if(max.peek()<data){
            max.push(newNode);
            max.size++;
        }
    }
    public Integer pop(){
        int data= elem.pop();
        elem.size--;
        if(data==min.peek()){
            min.pop();
            max.size--;
        }
        if(data==max.peek()){
            max.pop();
            max.size--;
        }
        return data;
    }
    public Integer min(){
        if(min.isEmpty()){
            return Integer.MAX_VALUE;
        }
        return  min.peek();
    }
    public Integer max(){
        if(max.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return max.peek();
    }

    public static void main(String[] args) {
        GetMinElement_inO1 g=new GetMinElement_inO1();
        for (int i = 79; i <100 ; i++) {
            g.push(new Node(i));
        }
        System.out.println(g.min());
        System.out.println(g.max());
        System.out.println(g.max.size);
        System.out.println(g.min.size);
    }
}
