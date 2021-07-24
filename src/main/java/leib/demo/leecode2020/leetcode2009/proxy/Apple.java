package leib.demo.leecode2020.leetcode2009.proxy;

/**
 * @Author:Leib
 * @Date 2020/9/17 20:13
 */
public class Apple implements Fruit{
    String name ;
    String weight;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
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
