package javaee.thread.functions;

//yield 线程礼让
//Thread的静态方法
//Thread.yield();
//让当前正在执行的线程暂停，不阻塞
//线程从运行态转为就绪态
//礼让不一定成功,看cpu调度

public class YieldTest implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程礼让");
    }
    public static void main(String[] args) {
        YieldTest yieldTest=new YieldTest();
        new Thread(yieldTest,"a").start();
        new Thread(yieldTest,"b").start();
    }
}
