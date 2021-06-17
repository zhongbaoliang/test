package javaee.oop.lambda;

//将一段代码作为参数传递

//不带参数时 ()->{}

//带多个参数时  (int a,String str)->{}
//        (a,str)->{}
//

//方法只有一行代码时{}可以去掉
//一个参数时可以去掉()
//类型要么都去掉，要么都保留

//lambda与匿名内部类区别
//1. 适用范围不同。
//   匿名内部类可以对接口、抽象类、类 使用。如HashMap添加多个元素
//   lambda只能对函数式接口使用
//2. Class对象生成时机不同。
// 匿名内部类编译时生成字节码.class，lambda在运行时生成，导致了域的作用范围不同。
//   2.1. this不同。匿名内部类中this是匿名内部类的，lambda的this是外部类的
//         2.1.1. 调用方法不同。匿名内部类可以调用接口中普通方法而lambda不行。如HashMap添加多个元素
//         2.1.2. 变量不同
//3. lambda更简洁。

import org.junit.Test;

public class Lambda {


    String l="class var";
    //2. 静态内部类
    static class ClassTestable2 implements InterfaceTestable{
        @Override
        public void lambda() {
            test();
            System.out.println("静态内部类 lambda2 implements InterfaceTest");
        }
    }
    @Test
    public void test1() {
        InterfaceTestable classTestable;

        classTestable=new ClassTestable1();
        classTestable.lambda();

        classTestable=new ClassTestable2();
        classTestable.lambda();

        int num=123;

        //3. 局部内部类
        class ClassTestable3 implements InterfaceTestable{
            @Override
            public void lambda() {
                test();
                //num++;//内部类使用同级别的成员变量时，变量默认为final
                System.out.println(num+"局部内部类 lambda3 implements InterfaceTest");
            }
        }
        classTestable=new ClassTestable3();
        classTestable.lambda();

        System.out.println("------------------------------------------------");

        //4. 匿名内部类
        classTestable=new InterfaceTestable() {
            @Override
            public void lambda() {
                test();
                System.out.println(this.l);
                System.out.println("匿名内部类 lambda4 implements InterfaceTest");
            }
        };
        classTestable.lambda();

        System.out.println("------------------------------------------------");

        //lambda表达式
        classTestable=()->{
            //test();
            System.out.println(this.l);
            System.out.println("lambda表达式 lambda5 implements InterfaceTest");
        };
        classTestable.lambda();
    }
}

//1. 实现类
class ClassTestable1 implements InterfaceTestable{
    @Override
    public void lambda() {
        test();
        System.out.println("实现类 lambda1 implements InterfaceTest");
    }
}

