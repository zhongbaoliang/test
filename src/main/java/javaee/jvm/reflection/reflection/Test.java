package javaee.jvm.reflection.reflection;


import java.lang.reflect.*;

//通过反射获取运行时类的完整结构
//Field、Method、Constructor、Superclass、Interface、Annotation
//字段  、方法   、构造器      、父类       、接口      、引用

//优点：灵活（动态创建对象）
//缺点：性能低（解释性操作，编译器不能对其优化）、不安全、内部信息暴露


public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class c1=Class.forName("javaee.jvm.reflection.reflection.User");

        //通过构造器创建对象
        Constructor[] constructors =c1.getConstructors();//获得共有构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("---------------");
        constructors =c1.getDeclaredConstructors();//获得所有构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }


        //通过class对象的newInstance()创建对象;类中必须包含无参构造器，且为public
        System.out.println("---------------");
        User user=(User) c1.newInstance();//调用无参构造器
        System.out.println(user);


        //通过反射得到的构造器的newInstance()创建对象
        System.out.println("---------------");
        Constructor constructor=c1.getDeclaredConstructor(int.class,String.class,String.class,int.class);
        //System.out.println(constructor);
        user=(User)constructor.newInstance(123,"老王","男",47);
        System.out.println(user);

        System.out.println("---------------");
        constructor=c1.getDeclaredConstructor(int.class,String.class,String.class);
        //System.out.println(constructor);
        constructor.setAccessible(true);//让静私有方法可访问
        user=(User)constructor.newInstance(123,"老王","男");
        System.out.println(user);



        //Constructor constructor=c1.getConstructor();

    }
}
class User{
    private int id;
    private String name;
    private String gender="man";
    private int age=23;

    public User() {
    }

    public User(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    private User(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}