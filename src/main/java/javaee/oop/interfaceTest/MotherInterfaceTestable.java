package javaee.oop.interfaceTest;

public interface MotherInterfaceTestable {
    default void fun(){
        System.out.println("Default  interface fun");
    }


    void func();
}
