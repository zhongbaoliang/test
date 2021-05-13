package javaee.OOPTest;

//枚举类，JVM禁止对枚举类使用new ，单例模式
//没有子类，不能被继承也不能被实现
//成员类型为 public static final
//不能通过反射创建对象

//当需要定义一组常量时，强烈建议使用
public enum EnumTest {
    TEST;
}
