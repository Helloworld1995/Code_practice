package DesighModel.adapter;

/**
 * 客户类
 * （相当于例子中的笔记本，只有USB接口）
 */
public class Client {
    public void test1(Target t){
        t.handleReq();
    }
    public static void main(String[] args) {
    Client client=new Client();
    Adpatee a=new Adpatee();
    Target t=new Adpater(a);
    client.test1(t);
    }
}
