package javaee.thread.newThread;
//创建线程方式一：
// 继承Thread类，
// 重写run方法；
// 通过start开启线程
//run()方法只是普通方法
//start()方法是开启线程方法，被调用后线程进入就绪态。
// start()方法内部异步调用run()方法
public class ExtendsThread extends Thread{
    long data = 10;
    public ExtendsThread(long minPrime){
        this.data=minPrime;
    }

    @Override
    public void run(){
        for(int i=0;i<data;i++)
            System.out.println("Hello, i am sub thread ExtendsThread" + i);
    }
    public static void main(String arg[]){
        ExtendsThread extendsThread = new ExtendsThread(10);
        extendsThread.start();

        for(int i=0;i<10;i++)
            System.out.println("Hello, i am JavaEE.Main thread ExtendsThread" + i);
    }
}