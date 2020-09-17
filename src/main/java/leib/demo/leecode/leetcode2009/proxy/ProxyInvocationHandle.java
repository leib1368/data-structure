package leib.demo.leecode.leetcode2009.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author:Leib
 * @Date 2020/9/17 17:31
 */
public class ProxyInvocationHandle implements InvocationHandler {

    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(object, args);
        return invoke;
    }
}