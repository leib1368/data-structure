package leib.demo.leecode.leetcode2011;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author:Leib
 * @Date 2020/11/5 10:16
 */
public class T1105 {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        List<User1> list = new ArrayList<>();
        IntStream.range(0, 10).forEach(it -> {
            User1 user = new User1("name" + it, it, (it <= 5) ? "男" : "女", "1361234567" + it, "echo" + it + "@163.com");
            list.add(user);
        });
        Map<Object, Map<String, Map<String, Map<String, List<User1>>>>> collect = list.stream()
                .filter(it -> StringUtils.isNotEmpty(it.getName()))
                .filter(it -> !ObjectUtils.isEmpty(it.getAge()))
                .peek(it -> {
                    if ("男".equals(it.getSex()))
                        it.setSex("1");
                    else
                        it.setSex("2");
                })
                .collect(Collectors.groupingBy(it -> {
                            if (it.getAge() > 5)
                                return false;
                            return true;
                        },
                        Collectors.groupingBy(User1::getName,
                                Collectors.groupingBy(User1::getEmail,
                                        Collectors.groupingBy(User1::getPhone)))));
        collect.forEach((a, b) -> b.forEach((c, d) -> {
            d.forEach((e, f) -> f.forEach((g, h) -> {
                h.forEach(it -> System.out.println(String.format("%s %s %s %s %s", a, c, e, g, it)));
            }));
        }));
    }


}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User1 {
    String name;
    Integer age;
    String sex;
    String phone;
    String email;
}