package javaee.tools.OOPTest;

//两个父接口中可以有同样的方法
// 但不能有同样的默认方法
public interface InterfaceTestable extends FatherInterfaceTestable, MotherInterfaceTestable {
    int a = 0;
    void func1();
    default void func2(){
        System.out.println("Default  interface func2");
        return ;
    }
}
