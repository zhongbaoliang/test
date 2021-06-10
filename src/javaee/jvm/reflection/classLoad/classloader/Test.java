package javaee.jvm.reflection.classLoad.classloader;

public class Test {
    static {
        System.out.println("main class clinit()");
    }

    public static void main(String[] args) throws InterruptedException {
        //System.out.println(SubClass.name);//通过子类使用父类的静态成员，初始化父类而不初始化子类
        System.out.println(SubClass.age);//使用子类的静态成员，先初始化父类再初始化子类
        //System.out.println(SubClass.gender);//使用类的静态常量不会初始化类
        //SubClass[] arr=new SubClass[10];//分配了空间。但是加载的时候就知道类的大小，因此暂时不需要初始化（没有new SubClass()）

        Thread.sleep(1000);
    }
}
