package javaee.thread;


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
            System.out.println(Thread.currentThread().getName() + " localVar before remove : " + localVar.get());
            //清除本地内存中的本地变量
            localVar.remove();
            //打印本地变量
            System.out.println(Thread.currentThread().getName() + " localVar after remove : " + localVar.get());
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