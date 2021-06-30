package javaee.jvm.reflection.classLoad.classloader;

public class SubClass extends SuperClass{
    static {
        System.out.println("SubClass clinit()");
    }
    static int age=20;
}
