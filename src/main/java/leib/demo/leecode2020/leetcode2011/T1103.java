package leib.demo.leecode2020.leetcode2011;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author:Leib
 * @Date 2020/11/3 21:32
 */
public class T1103 {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("aa");
//        T1103 t1103 = new T1103();
//        t1103.fun(list,"aa");

        List<User> userList = new ArrayList<>();
        userList.add(new User("1", "peter", 18));
        userList.add(new User("2", "stark", 25));
        userList.add(new User("2", "peter", 22));

        Set<User> userSet = new HashSet<>(userList);
        List<User> list1= new ArrayList<>(userSet);
        list1.forEach(System.out::println);
    }

    public List<String> fun(List<String> list, String element) {
        for (int i = 0, len = list.size(); i < len; i++) {
            if (list.get(i) == element) {
                list.remove(i);
                len--;
                i--;
            }
        }
        return list;
    }
}
