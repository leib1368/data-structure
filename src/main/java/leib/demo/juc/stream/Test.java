package leib.demo.juc.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/5/20 21:21
 */
public class Test {
    public static void main(String[] args) {
        User u1 = new User(1,"zs",23);
        User u2 = new User(2,"ls",21);
        User u3 = new User(3,"ww",18);
        User u4 = new User(4,"xm",35);
        User u5 = new User(5,"ab",66);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        list.stream()
                .filter(u-> u.getId()%2==0)
                .map(u-> u.getName().toUpperCase())
                .sorted((uu1,uu2)->{return uu1.compareTo(uu2);})
                .limit(1)
                .forEach(System.out::println);
    }
}
