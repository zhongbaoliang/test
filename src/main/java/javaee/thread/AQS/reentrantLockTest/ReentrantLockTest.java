package javaee.thread.AQS.reentrantLockTest;

import java.util.concurrent.locks.ReentrantLock;
//隐式锁synchronized
//显式锁Lock 更灵活
//ReentrantLock
//可重入锁,可以重复加锁，加几次必须释放几次，否则死锁
//使用变量前加锁，用完后解锁
//推荐使用以下格式
//private final ReentrantLock lock=new ReentrantLock();
//
//try{
//    lock.lock();
//    /*代码区*/
//}
//finally{
//    lock.unlock();
//}


/**
 * 包含 继承AbstractQueuedSynchronizer抽象类的静态内部类Sysc
 * 并持有Sync的实例
 * 并对Sync进行了两种实现（公平锁和非公平锁），默认创建的是非公平锁
 *
 *AQS中包含VersionId，state，和一个双向循环链表
 *
 */

/**
 * ReentrantLock与synchronized的区别：
 * 1. 所属范畴。前者是juc包下的类，后者是关键字
 * 2. 是否是要手动释放。前者需要手动释放，后者不需要。
 * 3. 锁定的内容。前者锁定的是线程，后者锁定的是对象。
 * 4. 是否可中断。前者可以通过tryLock的timeout进行中断。
 * 5. 可以通过condition.signal精确唤醒线程，而后者只能通过notify或者notifyAll随机唤醒。
 * 6. 公平性。前者可实现公平和非公平，后者只能实现非公平。
 *
 */

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