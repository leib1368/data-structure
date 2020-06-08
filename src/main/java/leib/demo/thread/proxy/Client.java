package leib.demo.thread.proxy;

/**
 * @Author:Leib
 * @Date 2020/5/26 17:25
 */
public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //代理角色 不存在的
        Proxy pih = new Proxy();
        //设置要代理的对象
        pih.setTarget(host);
        //动态生成代理类
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();
        proxy.sale();
    }
}
