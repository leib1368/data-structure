package leib.demo.leecode2020.leetcode2009.proxy;

/**
 * @Author:Leib
 * @Date 2020/9/17 20:13
 */
public class Apple implements Fruit{
    String name ;

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void eatApple() {
        System.out.println("eat apple");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
