package leib.demo.leecode2020.leetcode2005;

/**
 * @Author:Leib
 * @Date 2020/5/8 19:34
 */
public class Test {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.staticMethod();

        Parent child=new Child();
        child.staticMethod();//输出：Parent staticMethod run


        Child c=new Child();
        c.staticMethod();
        child.method();//这样才存在多态

        System.out.println(p.s2);
        System.out.println(child.s2);

        //Integer的缓存范围(-128~127)
/*
        Integer i1 = 6;
        Integer i2 = 6;
        System.out.println((i1==i2));//true


        Integer i3 = new Integer(6);
        Integer i4 = new Integer(6);

        System.out.println((i3==i4));//false
        System.out.println((6==i3));
        System.out.println((i3==6));
        System.out.println((128==i3));
        System.out.println((i4==128));

        System.out.println((i3==i4)+" "+i3.hashCode()+" "+i4.hashCode());
*/


    }
}
