package leib.demo.leecode.leetcode2009.proxy;

import leib.demo.leecode.leetcode2009.proxyFactory.BeforeAdvice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:Leib
 * @Date 2020/9/17 20:14
 */
public class Test {
    public static void main(String[] args) {

    }
    BeforeAdvice beforeAdvice;

    InvocationHandler h = new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(beforeAdvice != null) {
                beforeAdvice.before();
            }
            return null;
        }
    };


    public BeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }
    public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }
}
