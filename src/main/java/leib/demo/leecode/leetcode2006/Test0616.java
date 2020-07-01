package leib.demo.leecode.leetcode2006;

/**
 * @Author:Leib
 * @Date 2020/6/17 14:13
 */
public class Test0616 {
    public static void main(String[] args) {
        System.out.println(WeekEnum.FRIDAY.compareTo(WeekEnum.MONDAY));
        System.out.println(WeekEnum.FRIDAY.compareTo(WeekEnum.SUNDAY));
        System.out.println(WeekEnum.FRIDAY.compareTo(WeekEnum.SATURDAY));

        System.out.println(WeekEnum.FRIDAY.name());

        // 没有重写 toString 方法
        for (WeekEnum we : WeekEnum.values()) {
            System.out.println(we);
        }

        System.out.println(WeekEnum.SUNDAY.ordinal());
        System.out.println(WeekEnum.FRIDAY.ordinal());
        /*
        int ordinal()： 返回枚举值在枚举类中的索引值(从0开始)，
        即枚举值在枚举声明中的顺序，这个顺序根据枚举值声明的顺序而定；
        */

        System.out.println(WeekEnum.valueOf(WeekEnum.class, "MONDAY"));
        System.out.println(WeekEnum.valueOf(WeekEnum.class, "FRIDAY"));
        System.out.println(WeekEnum.valueOf(WeekEnum.class, "SUNDAY"));

        Gender.man.getSex();
    }
}
