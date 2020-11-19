package DesighModel.proxy.dynamicProxy;
import DesighModel.proxy.static_proxy.ProxyMan;
import DesighModel.proxy.static_proxy.Star;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Star star=new RealStar();
        StarHandler handler=new StarHandler((RealStar) star);//代理star
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);//返回代理
        proxy.sing(); //实际执行StarHandler中的invoke函数，换句话说，执行代理对象方法时被拦截
        proxy.confer();
    }
}
