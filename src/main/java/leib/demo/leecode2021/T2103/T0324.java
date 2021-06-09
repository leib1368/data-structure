package leib.demo.leecode2021.T2103;

import com.alibaba.fastjson.JSONObject;
import leib.demo.leecode2020.leetcode2009.proxy.Apple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Leib
 * @Date 2021/3/24 20:55
 */
public class T0324 {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setName("apple");
        Map map = new HashMap<String,Object>() ;
        map.put("a",apple);
        System.out.println(map.get("a").getClass());
        JSONObject jsonObject;
    }
}
