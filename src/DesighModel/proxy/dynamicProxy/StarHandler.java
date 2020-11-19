package DesighModel.proxy.dynamicProxy;

import DesighModel.proxy.static_proxy.ProxyMan;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {
    private RealStar star;
    public StarHandler(RealStar star){
        this.star=star;

    }
    @Override
    /**
     * proxy:动态代理对象
     * method:代表正在执行的方法
     * args：方法的参数
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object=null;
        System.out.println("before invoke");
        object = method.invoke(star, args);
        System.out.println("after invoke");
        return object;
    }
}
