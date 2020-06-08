package leib.demo.thread.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:Leib
 * @Date 2020/5/26 17:29
 */
public class Proxy implements InvocationHandler {
    //被代理的接口
    private Object target;
    public void setTarget(Rent target){this.target = target;}

    //生成得到代理类
    public java.lang.Object getProxy(){
        return java.lang.reflect.Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    //处理代理实例,并返回结果
    @Override
    public java.lang.Object invoke(java.lang.Object proxy,
                                   Method method,
                                   java.lang.Object[] args) throws Throwable {
        //此时类似aop的应用 可以方法执行前增加
        log(method.getName());
        java.lang.Object invoke = method.invoke(target, args);
        //方法执行后也行
        log(method.getName());
        return invoke;
    }
    public void log (String msg){
        System.out.println("msg");
    }
}
