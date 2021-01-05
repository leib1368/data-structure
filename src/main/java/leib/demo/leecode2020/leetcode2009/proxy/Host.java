package leib.demo.leecode2020.leetcode2009.proxy;

/**
 * @Author:Leib
 * @Date 2020/9/17 15:55
 */
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房东出租");
    }
}
