package leib.demo.leecode.leetcode2011;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author:Leib
 * @Date 2020/11/3 22:24
 */
@Data
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private int age;

    public boolean equals(Object obj) {
        User u = (User) obj;
        return name.equals(u.name) && id.equals(u.id);
    }

    public int hashCode() {
        String in = name + id;
        return in.hashCode();
    }

}
