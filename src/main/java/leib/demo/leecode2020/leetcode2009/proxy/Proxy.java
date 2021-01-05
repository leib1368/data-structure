package leib.demo.leecode2020.leetcode2009.proxy;

/**
 * @Author:Leib
 * @Date 2020/9/17 15:58
 */
public class Proxy implements Rent{
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
    }
}
