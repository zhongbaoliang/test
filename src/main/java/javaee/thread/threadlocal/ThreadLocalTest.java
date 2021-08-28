package javaee.thread.threadlocal;

//ThreadLocal
//线程私有
//作用：相当于一个全局变量，可以有初始化值，每个线程私有

//应用点：PageHelper、SimpleDateFormat全局

//问题：key为弱引用，key所指向的对象被回收了，key就变成了Null,value也就无法使用了，但未被回收，也就造成了内存泄漏。
//解决：每次使用完手动remove，底层实现时每次使用get、set、remove方法都会remove所有key为null对应的value。

public class ThreadLocalTest {

    static ThreadLocal<String> localVar = new ThreadLocal<>();

    public static void main(String[] args) {
        //localVar.set("main ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t1  = new Thread(()-> {
            //设置线程1中本地变量的值
            localVar.set("localVar1");
            //打印当前线程中本地内存中本地变量的值
            System.out.println(Thread.currentThread().getName() +
                    " localVar before remove : " + localVar.get());
            //清除本地内存中的本地变量
            localVar.remove();
            //打印本地变量
            System.out.println(Thread.currentThread().getName() +
                    " localVar after remove : " + localVar.get());
        });

        Thread t2  = new Thread(()->{
            //设置线程1中本地变量的值
            localVar.set("localVar2");
            //打印当前线程中本地内存中本地变量的值
            System.out.println(Thread.currentThread().getName() + " localVar before remove : " + localVar.get());
            //清除本地内存中的本地变量
            localVar.remove();
            //打印本地变量
            System.out.println(Thread.currentThread().getName() + " localVar after remove : " + localVar.get());

        });

        t1.start();
        t2.start();
    }
}