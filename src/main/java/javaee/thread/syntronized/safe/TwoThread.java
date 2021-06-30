package javaee.thread.syntronized.safe;
//两个线程交替执行

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//两个线程交替执行
public class TwoThread  {

    //使用synchronized，notify，wait
    public static void func1(){
        final Object object = new Object();
        new Thread(()->{
            for (int i = 0; i <= 8; i+=2) {
                synchronized (object) {
                    object.notify();
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    if(i==8)
                        return ;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(()->{
            for (int i = 1; i <= 9; i+=2) {
                synchronized (object) {
                    object.notify();
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    if(i==9)
                        return ;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start(); ;
    }


    //使用Lock,condition,signal,await
    public static void func2(){
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            public void run() {
                try {
                    int i = 0;
                    while(true){
                        lock.lock();
                        condition.signal();
                        System.out.println(Thread.currentThread().getName() + "：" + i);
                        condition.await();
                        i=i+2;
                        if(i==8)
                            return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                try {

                    int i = 1;
                    while(true){
                        lock.lock();
                        condition.signal();
                        System.out.println(Thread.currentThread().getName() + "：" + i);
                        condition.await();
                        i=i+2;
                        if(i==9)
                            return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

    }

    //使用堵塞队列结合线程使用
    public static void func3(){
        final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
        final BlockingQueue<Integer> blockingQueue1 = new ArrayBlockingQueue<Integer>(10);
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <= 8; i+=2) {
                    try {
                        blockingQueue.put(i);
                        System.out.println(blockingQueue1.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 9; i+=2) {
                    try {
                        System.out.println(blockingQueue.take());
                        blockingQueue1.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        //func1();
        func3();
    }

}