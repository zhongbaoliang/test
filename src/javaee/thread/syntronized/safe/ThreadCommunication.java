package javaee.thread.syntronized.safe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCommunication {

    //方法1 synchronized,wait,notify
    public static class Demo1 {

        private final List<Integer> list =new ArrayList<>();

        public static void main(String[] args) {
            Demo1 demo =new Demo1();
            new Thread(()->{
                for (int i=0;i<10;i++){
                    synchronized (demo.list){
                        if(demo.list.size()%2==1){
                            try {
                                demo.list.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        demo.list.add(i);
                        System.out.print(Thread.currentThread().getName());
                        System.out.println(demo.list);
                        demo.list.notify();
                    }
                }

            }).start();

            new Thread(()->{
                for (int i=0;i<10;i++){
                    synchronized (demo.list){
                        if(demo.list.size()%2==0){
                            try {
                                demo.list.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        demo.list.add(i);
                        System.out.print(Thread.currentThread().getName());
                        System.out.println(demo.list);
                        demo.list.notify();
                    }
                }
            }).start();
        }
    }

    //方法2 Lock、Condition
    public static class Demo2{
        private final Lock lock=new ReentrantLock();
        private final Condition addCondition = lock.newCondition();
        private final Condition subCondition = lock.newCondition();
        private volatile int num=0;
        private List<String> list=new ArrayList<>();

        public void add(){
            for(int i=0;i<10;i++){
                lock.lock();
                try{
                    if(list.size()%2==1)
                        addCondition.await();
                    num++;
                    //Thread.sleep(1000);
                    list.add("add "+num);
                    System.out.println("The list size is " + list.size());
                    System.out.println("The add thread is " + Thread.currentThread().getName());
                    System.out.println("------------");
                    //lock.notifyAll();
                    subCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            }
        }

        public void sub(){
            for(int i=0;i<10;i++){
                lock.lock();
                try{
                    if(list.size()%2==0)
                        subCondition.await();
                    num--;
                    //Thread.sleep(1000);
                    list.remove(0);
                    System.out.println("The list size is " + list.size());
                    System.out.println("The sub thread is " + Thread.currentThread().getName());
                    System.out.println("------------");
                    addCondition.signal();
                    //lock.notifyAll();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            }
        }

        public static void main(String[] args) {
            Demo2 task=new Demo2();
            new Thread(task::add).start();
            new Thread(task::sub).start();
        }
    }

    //方法3 原子操作
    public static class Demo3{
        public static AtomicInteger atomicInteger=new AtomicInteger(1);

        public static void main(String[] args) {
            new Thread(()->{
                for(int i=0;i<10;i+=2){
                    while (atomicInteger.get()!=1){}
                    System.out.println(Thread.currentThread().getName()+" running");
                    atomicInteger.set(2);
                }
            }).start();


            new Thread(()->{
                for(int i=1;i<10;i+=2) {
                    while (atomicInteger.get() != 2) ;
                    System.out.println(Thread.currentThread().getName() + " running");
                    atomicInteger.set(1);
                }
            }).start();

        }
    }

    //方法4 管道流
    public static class Demo4 {

        private final PipedInputStream inputStream1;
        private final PipedOutputStream outputStream1;
        private final PipedInputStream inputStream2;
        private final PipedOutputStream outputStream2;

        public Demo4(){
            inputStream1 = new PipedInputStream();
            outputStream1 = new PipedOutputStream();
            inputStream2 = new PipedInputStream();
            outputStream2 = new PipedOutputStream();
            try {
                inputStream1.connect(outputStream2);
                inputStream2.connect(outputStream1);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        /**程序退出时，需要关闭stream*/
        public void shutdown() throws IOException {
            inputStream1.close();
            inputStream2.close();
            outputStream1.close();
            outputStream2.close();
        }

        public static void main(String[] args) throws IOException {
            Demo4 demo =new Demo4();
            new Thread(()->{
                PipedInputStream in = demo.inputStream2;
                PipedOutputStream out = demo.outputStream2;

                for (int i = 0; i < 10; i++) {
                    try {
                        byte[] inArr = new byte[2];
                        in.read(inArr);
                        System.out.print(Thread.currentThread().getName()+": "+i+" ");
                        System.out.println(new String(inArr));
                        while(true){
                            if("go".equals(new String(inArr)))
                                break;
                        }
                        out.write("ok".getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();

            new Thread(()->{
                PipedInputStream in = demo.inputStream1;
                PipedOutputStream out = demo.outputStream1;

                for (int i = 0; i < 10; i++) {
                    try {
                        out.write("go".getBytes());
                        byte[] inArr = new byte[2];
                        in.read(inArr);
                        System.out.print(Thread.currentThread().getName()+": "+i+" ");
                        System.out.println(new String(inArr));
                        while(true){
                            if("ok".equals(new String(inArr)))
                                break;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
//        demo.shutdown();
        }
    }

    //方法5 阻塞队列
    public static class Demo5{
        static BlockingQueue blockingQueue=new ArrayBlockingQueue(1);

        public static void main(String[] args) {
            new Thread(()->{
                for(int i=0;i<10;i+=2) {
                    {
                        try {
                            blockingQueue.put(i);
                            System.out.println(Thread.currentThread().getName() + " putting " + i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();

            new Thread(()->{
                for(int i=1;i<10;i+=2) {
                    Integer a = new Integer(-1);
                    {
                        try {
                            a = (Integer) blockingQueue.take() + 1;
                            System.out.println(Thread.currentThread().getName() + " taking " + a);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }).start();
        }
    }

    //方法6 信号量
    public static class Demo6{
        static final Semaphore semaphore=new Semaphore(1);

        public static void main(String[] args) {
            new Thread(()->{
                for (int i = 0; i < 10; i+=2) {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+" "+i);
                        Thread.yield();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        semaphore.release();
                    }

                }
            }).start();

            new Thread(()->{
                for (int i = 1; i < 10; i+=2) {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+" "+i);
                        Thread.yield();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        semaphore.release();
                    }

                }

            }).start();
        }
    }

}
