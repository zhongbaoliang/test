package javaee.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

//volatile
//修饰变量
// 保证变量的可见性 ; 写操作立马写主存，线程的监听器监听主存数据变化，若变了则使线程内存数据副本失效
// 前后代码的有序性（禁止指令重排序）; 内存屏障
// 不保证操作的原子性

//Thread.activeCount()存活线程个数，不包括守护线程;
//最少为2；Monitor Ctrl-Break和Main
public class VolatileTest {
    public static volatile Integer inc = new Integer(0);//不能保证原子性
    public volatile static boolean stop=false;//保证可见性
    public synchronized static void increase() {
        inc++;
    }

    //测试可见性
    public static void testV(){
        Thread t1=new Thread(()->{
            while(!stop){
                Date date=new Date(System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName()+
                        new SimpleDateFormat("hh:mm:ss").format(date) + " running");

            }
        });

        Thread t2=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop=true;
            System.out.println(Thread.currentThread().getName()+
                    " stop=true 保证了可见性");
        });

        t1.start();
        t2.start();
    }

    //测试原子性
    public static void testA(){
        for(int i=0;i<10;i++){
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    //synchronized (VolatileTest.class)
                    {
                        inc++;
                    }
                    //increase();
//                    synchronized (inc){
//                        inc++;
//                    }
                }
            }).start();
        }

        while(Thread.activeCount()>2){
            ////Thread.activeCount()存活线程个数，不包括守护线程
            // System.out.println(Thread.activeCount());
            Thread.yield();//礼让CPU
            //虽然礼让有可能不成功，但是会一只礼让到成功
        }

        System.out.println(inc);
    }
    public static void main(String[] args) {
        //testV();
        testA();


    }

}