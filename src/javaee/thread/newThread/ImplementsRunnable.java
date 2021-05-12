package javaee.thread.newThread;

//创建线程方式二
//自定义类 实现runnable接口
//重写run方法
//创建自定义类实例
//创建Thread实例，并将自定义类的实例作为参数传入
//（创建Thread类的原因是 start方法属于Thread类

//外部类
//静态内部类
//局部内部类
//匿名内部类
//lambda表达式

//同步，对象等待池 队列
public class ImplementsRunnable implements Runnable {
    private int data = 10;//多个线程操作同一个对象

    public ImplementsRunnable(int data) {
        this.data = data;
    }

    public ImplementsRunnable() {

    }

    @Override
    public void run(){

        //sout
        //System.out.println();
        while(data>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello, i am ImplementsRunnable thread " + Thread.currentThread().getName()+" get data "+data--);

        }
        //100.for
    }


    public static void main(String arg[]) throws InterruptedException {
        ImplementsRunnable implementsRunnable =new ImplementsRunnable(10);
        Thread thread =new Thread(implementsRunnable,"子线程1");
        Thread thread1=new Thread(implementsRunnable,"子线程2");
        Thread thread2=new Thread(implementsRunnable,"子线程3");
        //System.out.println(thread.);
        thread.start();
        thread1.start();
        thread2.start();
        //Thread.yield();
        //read thread1=new Thread(new ImplementsRunnable(10));



        for(int i=0;i<10;i++){
            //Thread.sleep(100);
            System.out.println("Hello, i am ImplementsRunnable thread " + Thread.currentThread().getName());
        }

        //匿名内部类
        Thread thread11=new Thread() {
            @Override
            public void run() {

            }
        };

        //lambda表达式
        Thread thread22 = new Thread(()->{

        });



    }
}
