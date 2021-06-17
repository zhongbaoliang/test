package javaee.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//隐式锁synchronized
//显式锁Lock 更灵活
//ReentrantLock
//可重入锁
//使用变量前加锁，用完后解锁
//推荐使用以下格式
//private final ReentrantLock lock=new ReentrantLock();
//lock.lock();
//try{
//    /*代码区*/
//}
//finally{
//    lock.unlock();
//}
public class ReentrantLockTest {
    public static void main(String[] args) {
        BuyTicket unsafeBuyTicket=new BuyTicket();
        Thread thread1=new Thread(unsafeBuyTicket);
        Thread thread2=new Thread(unsafeBuyTicket);
        Thread thread3=new Thread(unsafeBuyTicket);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class BuyTicket implements Runnable{
    private int ticketNums=10;
    boolean flag=true;
    private final ReentrantLock reentrantLock=new ReentrantLock();
    //给票加锁，因此使用票时加锁
    //使用完毕解锁
    @Override
    public void run() {
        //买票
        while(flag){
            try{
                reentrantLock.lock();
                buy();
            }
            finally {
                reentrantLock.unlock();
            }

        }

    }
    private void buy(){
        if(ticketNums<=0){
            flag=false;
            return;
        }
        //this
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 买到了 " + ticketNums--);

    }

}