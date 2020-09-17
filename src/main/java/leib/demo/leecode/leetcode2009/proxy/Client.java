package leib.demo.leecode.leetcode2009.proxy;

import java.util.ArrayList;

/**
 * @Author:Leib
 * @Date 2020/9/17 15:57
 */
public class Client {
    public static void main(String[] args) {
//        Host host = new Host();
//        Proxy p = new Proxy(host);
//        p.rent();

        UserService userService = new UserService() {
            @Override
            public void add() {
                System.out.println("aaa");
            }
        };

        ArrayList list = new ArrayList();

        UserServiceImpl u = new UserServiceImpl();
        ProxyInvocationHandle pis = new ProxyInvocationHandle();
        pis.setObject(u);
        UserService proxy = (UserService)pis.getProxy();
        proxy.add();
    }
}
