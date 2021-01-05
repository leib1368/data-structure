package leib.demo.leecode2020.leetcode2006;

/**
 * @Author:Leib
 * @Date 2020/6/17 14:22
 */
public enum Gender implements GenderDescription {
    man("男"),woman("女");

    private String sex;
    @Override
    public void showInfo() {
        System.out.println("这是一个用于定义性别的枚举类"+sex);
    }

    private Gender(String sex){
        this.sex=sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
