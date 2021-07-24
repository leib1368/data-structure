package leib.demo.leecode2021.T2106;

import leib.demo.leecode2020.leetcode2009.proxy.Apple;
import org.springframework.beans.BeanUtils;

/**
 * @Author:Leib
 * @Date 2021/6/15 22:18
 */
public class T0615 {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        apple1.setName("a");
        //apple1.setWeight("w1");
        apple2.setWeight("w1");

        System.out.println(apple1);
        System.out.println(apple2);
        BeanUtils.copyProperties(apple1,apple2);
        System.out.println(apple1);
        System.out.println(apple2);
    }
}
