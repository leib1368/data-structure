package leib.demo.reflection;

import lombok.Data;

/**
 * @Author:Leib
 * @Date 2020/5/26 11:33
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println(person.name);

        Class c1 = person.getClass();
        System.out.println(c1.hashCode());
        Class c2 = Class.forName("leib.demo.reflection.Student");
        System.out.println(c2.hashCode());
        Class<Student> c3 = Student.class;
        System.out.println(c3.hashCode());

        //基本内置类型的包装类都有一个type属性
        Class<Integer> c4 = Integer.TYPE;
        System.out.println(c4);
        //获取父类
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}
@Data
class Person{
    public String name ;
    public Person (){
        this.name = "Person" ;
    }
}
class Student extends Person{
    public Student (){
        this.name = "Student" ;
    }
}
class Teacher extends Person{
    public Teacher (){
        this.name = "Teacher" ;
    }
}