package javaee.oop;

import java.util.Objects;
//未声明构造方法时会自动生成一个隐式无参构造方法
//已申明带参数构造方法，就不会自动生成隐式的无参构造方法
// 若要使用无参构造方法，必须先申明
//

//重写equals时必须重写hashcode

class Student{

    String id;
    String name;
    int age;
    int studentId;

    public Student(String id, String name, int age, int studentId) {
        //super(id, name, age);
        this.id = id;
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
public class EqualsTest {
    public static void main(String[] args) {
        Student student1=new Student("123456","laowang",60,123);
        Student student2=new Student("123456","laowang",68,123);
        Student student3=new Student("123456","laowang",68,456);
        Student student4=new Student("123789","laowang",68,123);

        System.out.println("student1.equals(student2) " + student1.equals(student2));
        System.out.println("student1==student2 " +(student1==student2));

        System.out.println("student1.equals(student3) " + student1.equals(student3));
        System.out.println("student1==student3 " +(student1==student3));

        System.out.println("student1.equals(student4) "+student1.equals(student4));
        System.out.println("student1==student4 " +(student1==student4));

    }
}
