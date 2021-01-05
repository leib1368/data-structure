package leib.demo.leecode2020.leetcode2006;

/**
 * @Author:Leib
 * @Date 2020/6/6 19:37
 */
public class ValueCrossTest {
    public static void main(String[] args) {
        int a = 25;
        float w = 77.5f;
        valueCrossTest(a,w);
        System.out.println("main赋值后的age:"+a);
        System.out.println("main赋值后的weight:"+w);
    }
    public static void valueCrossTest(int age ,float weight ){
        System.out.println("传入的age:"+age);
        System.out.println("传入的weight:"+weight);
        age = 33;
        weight = 89.5f ;
        System.out.println("赋值后的age:"+age);
        System.out.println("赋值后的weight:"+weight);
    }
}
