package javaee.jvm.reflection.classLoad.classloader;

public class SuperClass {
    static {//加载，链接（校验，准备，解析），初始化。发生在初始化阶段
        System.out.println("SuperClass clinit()");
    }
    public static String name="123";//加载，链接（校验，准备，解析），初始化。发生在初始化过程
    public final static String gender="man";//加载，链接（检验，准备，解析），初始化。发生在准备阶段
}
