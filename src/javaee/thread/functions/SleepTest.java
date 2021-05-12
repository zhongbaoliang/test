package javaee.thread.functions;

//sleep 线程休眠
//Thread的静态方法
//Thread.sleep(1000);
//1. 不释放资源，线程进入就绪态
//2. 阻塞时间为ms
//3. 存在异常InterruptedException
//4. 每个对象都有一个锁，sleep不会释放锁
//5. sleep可以模拟网络延时，倒计时

import javaee.thread.ImplementsRunnable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepTest implements Runnable {
     private int data = 10;

    public SleepTest(int data) {
        this.data = data;
    }

    @Override
    public void run() {
        //System.out.println();
        while (data > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello, i am ImplementsRunnable thread " + Thread.currentThread().getName() + " get data " + data--);

        }
        //100.for
    }

    //模拟网络延时
    public static void delay(){
        SleepTest sleepTest = new SleepTest(10);
        Thread thread = new Thread(sleepTest, "子线程1");
        Thread thread1 = new Thread(sleepTest, "子线程2");
        Thread thread2 = new Thread(sleepTest, "子线程3");
        //System.out.println(thread.);
        thread.start();
        thread1.start();
        thread2.start();
        //read thread1=new Thread(new ImplementsRunnable(10));


        for (int i = 0; i < 10; i++) {
            //Thread.sleep(100);
            System.out.println("Hello, i am ImplementsRunnable thread " + Thread.currentThread().getName());
        }
    }



    public static void main(String arg[]) throws InterruptedException {

        delay();
        Date date=new Date(System.currentTimeMillis());
        System.out.println(new SimpleDateFormat("YY:MM:dd:HH:mm:ss").format(date));



    }
}
