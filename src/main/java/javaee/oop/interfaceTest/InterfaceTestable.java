package javaee.oop.interfaceTest;

//两个父接口中可以有同样的方法
// 但不能有同样的默认方法
//接口中没有变量，所有的属性都是静态常量
//接口中方法都是公有的
//default提供方法默认实现
public interface InterfaceTestable extends FatherInterfaceTestable, MotherInterfaceTestable {
    int a = 0;
    void func1();
    default void func2(){
        System.out.println("Default  interface func2");
        return ;
    }
}
