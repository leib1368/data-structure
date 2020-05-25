package leib.demo.jvm;

/**
 * @Author:Leib
 * @Date 2020/5/22 20:51
 */
public class Car {
    public static void main(String[] args) {
        Car car1 = new Car();
        Class<? extends Car> aClass = car1.getClass();

        System.out.println(aClass.getClassLoader());
        System.out.println(aClass.getClassLoader().getParent());
        System.out.println(aClass.getClassLoader().getParent().getParent());

    }

}
/*
* 1. 类加载器收到类加载的请求
* 2. 将这个请求向上委托给父类加载器去完成，一直向上委托，直到启动类加载器
* 3. 类加载器坚持是否能够加载当前这个类，能加载就结束，使用当前的加载器。否则抛出异常，通知子加载器进行加载
* 4. 重复3
*
* null ： java调用不到
*/
