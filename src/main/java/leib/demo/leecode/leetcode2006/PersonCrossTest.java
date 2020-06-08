package leib.demo.leecode.leetcode2006;

/**
 * @Author:Leib
 * @Date 2020/6/6 20:20
 */
public class PersonCrossTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(1);
        p1.setName("马化腾");
        PersonCrossTest(p1);
        System.out.println("main执行后的name:"+p1.getName());
    }
    public static void PersonCrossTest(Person person){
        System.out.println("传入前name："+person.getName());
        person=new Person();//加多此行代码
        person.setName("张小龙");
        System.out.println("方法内赋值后name："+person.getName());
    }
}
