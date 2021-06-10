package javaee.jvm.reflection;

//反射机制是java语言被视为准动态语言的关键
//它允许程序在执行时借助Reflection API取得任何类的内部信息，并能直接操作任意对象的内部属性和方法（包括private
//正常方式：引入包->new实例化->获取实例对象
//反射方式：实例化对象->getClass()方法->得到完整的“包类”名称
//优点：灵活（动态创建对象，必须包含无参构造器）
//缺点：性能低（解释性操作，编译器不能对其优化）、不安全、内部信息暴露

//类、接口、数组、注解、枚举、基本数据类型都有class对象
import org.junit.Test;

import java.lang.annotation.ElementType;

//优点：可以动态的创建对象和编译，体现出很大的灵活性
//缺点：降低性能
public class ReflectionTest {

    @Test
    public void test1(){
        Class c1=Object.class;
        Class c2=Comparable.class;
        Class c3=String[].class;
        Class c4=int[][].class;
        Class c5=Override.class;
        Class c6= ElementType.class;
        Class c7=Integer.class;
        Class c8=void.class;
        Class c9=Class.class;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);


        //class对象与数组长度无关，只与类型和纬度有关
        int a[]=new int[10];
        int b[]=new int [100];
        System.out.println(a.getClass().equals(b.getClass()));
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class c1=Class.forName("javaee.jvm.reflection.Person");
        System.out.println(c1);


        Person user=new Student();
        Class c2=user.getClass();
        System.out.println(c2);

        Class c3=Teacher.class;
        System.out.println(c3);






    }
}

class Person{
    protected int id;
    protected String name;
    protected int age;

    public Person() {
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person{
    public Student() {
        this.name="学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name="老师";
    }
}
