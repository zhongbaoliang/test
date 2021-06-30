package javaee.thread.syntronized;

//同步方法 public synchronized void buy(){}
//同步代码块 synchronized(Obj){}
//Obj称之为同步监视器
//synchronized锁的对象 默认值是this
//synchronized 不能锁基本数据类型和String

public class SynTest extends Thread{
    @Override
    public void run(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+ " running");
            try {
                this.notify();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" end");
        }
    }

    public static void main(String[] args) {
        SynTest synTest=new SynTest();
        synchronized (synTest){
            System.out.println(synTest.getName()+" start");
            synTest.start();
            try {
                System.out.println(synTest.getName() +" wait");
                synTest.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(synTest.getName()+" notify");
            synTest.notify();

        }
        System.out.println("main end");
    }

}
