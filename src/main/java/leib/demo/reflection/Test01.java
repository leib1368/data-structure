package leib.demo.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:Leib
 * @Date 2020/5/26 11:22
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("leib.demo.reflection.User");
        System.out.println(c1);
        //一个类在内存中只有一个Class对象 因此再获取一个c2 也是和c1相等的
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
    private String name ;
    private int id;
    private int age;
}


