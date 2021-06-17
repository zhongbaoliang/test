package javaee.jvm.reflection.classLoad;
//类加载机制

//编译生成xxx.class字节码文件


//类初始化时机（若没加载则先加载）：首次使用时
    //1. new
    //2. 使用类的static
    //3. 反射
    //4. 初始化子类
    //5. 虚拟机启动时，初始化main()方法所在的类
//不被初始化情况
    //1. 通过子类使用父类的静态成员时，会初始化父类，而不会初始化子类
    //2. 通过数组定义类引用，不会触发此类的初始化
    //3. 引用常量不会触发此类的初始化


//双亲委派模型
//类加载器种类：
    //根类加载器
    //扩展类加载器
    //系统类加载起
    //自定义类加载器

//查找，从根类加载器到自定义类加载器
//先让父类加载，父类无法加载时自己加载

/**类加载过程
 * 1. 加载Load：将类的静态class文件读入内存，并为之创建一个java.lang.Class对象（由类加载器完成）
 * 2. 链接Link：将类的二进制数据合并到JRE；可细分为 验证、准备、解析
 * 2.1 验证：确保加载的类信息符合JVM规范，没有安全方面的问题
 * 2.2 准备：正式为类变量（static）分配内存空间，并设置static final变量的默认值，这些内存都在方法区分配。不对static赋初始值
 * 2.3 解析：常量符号的引用（类名）替换为class文件的地址
 * 3. 初始化Initialize：JVM负责对类进行初始化,初始化静态变量和静态代码段(会执行静态代码段)
 * 4. 使用
 * 5. 卸载
 * */

//构造代码块：在类中方法外出现；多个构造方法方法中相同的代码存放到一起，每次调用构造都执行，并且在构造方法前执行
    //可通过匿名内部类给构造代码块赋值，生成新的class对象
//静态代码块：在类中方法外出现，并加上static修饰；用于给类进行初始化，在加载的时候就执行，并且只执行一次。



//类加载完后，方法区产生一个Class类型的对象，一定时期该对象也会被作为垃圾清理

public class ClassLoadTest {

    public static void main(String[] args) {
        //获取 系统类加载器AppClassLoader又叫SystemClassLoader
        ClassLoader classLoader1=ClassLoader.getSystemClassLoader();
        System.out.println(classLoader1);

        //获取系统类加载器的父类加载器——扩展类加载器
        ClassLoader classLoader2=classLoader1.getParent();
        System.out.println(classLoader2);


        //获取扩展类加载器的父类加载器——根类加载器
        //由于根类加载器是由C/C++编写，无法直接获取
        ClassLoader classLoader3=classLoader2.getParent();
        System.out.println(classLoader3);
    }
}
