package data_structrue.Link_list_pkt.Stack.LinkStack;
public class LinkStack {
   Node top=null;
   int size=0;
   public void push(Node item){

       item.next=top;
       top=item;
       size++;
   }
   public int pop(){
    if(isEmpty()){
        throw new RuntimeException("空");
    }
    int item=top.data;
    top=top.next;
    return item;
   }
   public Integer peek(){
       if(isEmpty()){
           return null;
       }
       return top.data;
   }
   public boolean isEmpty(){
       return size==0;
   }

    public static void main(String[] args) {
       LinkStack stack=new LinkStack();
        for (int i = 0; i <20 ; i++) {
            stack.push(new Node(i));
        }
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

}
