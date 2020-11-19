package DesighModel.proxy.static_proxy;

public class Test {
    public static void main(String[] args) {
        RealStar star=new RealStar();
        ProxyMan proxyMan=new ProxyMan(star);
        proxyMan.bookTicket();
        proxyMan.collectMoney();
        proxyMan.confer();
        proxyMan.sing();
        proxyMan.confer();
    }
}
