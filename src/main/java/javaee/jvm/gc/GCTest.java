package javaee.jvm.gc;
//1. 什么对象可作为GCRoot的对象？
//保证当前是“活着的”
//a. 栈中的引用的对象。
//b.方法区中的类静态属性引用的对象。 （一般指被static修饰的对象，加载类的时候就加载到内存中。）
//c.方法区中的常量引用的对象。
//d.本地方法栈中的JNI（native方法）引用的对象
//e.活跃线程的引用对象

//2. 垃圾回收算法
//标记复制法
//标记清理法
//标记整理法

//3. minorGC和majorGC
//minorGC发生在新生代,，非常频繁，速度很快；采用标记复制法
//majorGC发生在老年代，必定伴随有minorGC，速度很慢；采用标记整理法

//eden,s1,s2,old
//大对象直接放入老年代
//存活时间达到最大（15）放入老年代
//动态年龄判断机制：s1里面有一对象object大小为s1的1/2，将年龄大于等于object的对象直接放入老年代
public class GCTest {
    public static void main(String[] args) {
        Cake c1 = new Cake(1);
        Cake c2 = new Cake(2);
        Cake c3 = new Cake(3);

        c2 = c3 = null;
        System.gc(); //Invoke the Java garbage collector
    }
}
class Cake {
    private int id;
    public Cake(int id) {
        this.id = id;
        System.out.println("Cake Object " + id + "is created");
    }

    protected void finalize() throws java.lang.Throwable {
        super.finalize();
        System.out.println("Cake Object " + id + "is disposed");
    }
}
