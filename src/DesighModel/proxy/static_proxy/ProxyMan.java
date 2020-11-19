package DesighModel.proxy.static_proxy;

public class ProxyMan implements Star{
    private RealStar star;
    public ProxyMan(RealStar star){
        this.star=star;
    }
    @Override
    public void confer() {
        System.out.println("ProxyMan.confer");
    }

    @Override
    public void signContract() {
        System.out.println("ProxyMan.signContract");
    }

    @Override
    public void bookTicket() {
        System.out.println("ProxyMan.bookTicket");
    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("ProxyMan.collectMoney");
    }
}
