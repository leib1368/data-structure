package leib.demo.reflection;

import lombok.Data;

import java.lang.annotation.*;

/**
 * @Author:Leib
 * @Date 2020/5/26 15:03
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> aClass = Class.forName("leib.demo.reflection.Students");
        //通过反射获取注解
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解的value的值
        Table table = aClass.getAnnotation(Table.class);
        String value = table.value();
        System.out.println(value);

        //获得类指定的注解
        java.lang.reflect.Field name = aClass.getDeclaredField("name");
        Field annotation = name.getAnnotation(Field.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }

}
@Data
@Table("db_stu")
class Students{
    @Field(columnName = "db_id",type = "int" ,length = 10)
    private int id ;
    @Field(columnName = "db_age",type = "int" ,length = 10)
    private int age ;
    @Field(columnName = "db_name",type = "varchar" ,length = 10)
    private String name ;
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Field{
    String columnName() ;
    String type() ;
    int length() ;
}