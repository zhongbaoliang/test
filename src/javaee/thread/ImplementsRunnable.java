package javaee.thread;

//创建线程方式二
//自定义类 实现runnable接口
//重写run方法
//创建自定义类实例
//创建Thread实例，并将自定义类的实例作为参数传入
//（创建Thread类的原因是 start方法属于Thread类

public class ImplementsRunnable implements Runnable {
    long data = 10;

    public ImplementsRunnable(long data) {
        this.data = data;
    }

    @Override
    public void run(){
        for(int i=0;i<data;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello, i am ImplementsRunnable sub thread " + i);
        }
    }

    public static void main(String arg[]) throws InterruptedException {
        ImplementsRunnable implementsRunnable =new ImplementsRunnable(10);
        Thread thread =new Thread(implementsRunnable);
        thread.start();
        //read thread1=new Thread(new ImplementsRunnable(10));



        for(int i=0;i<10;i++){
            Thread.sleep(100);
            System.out.println("Hello, i am ImplementsRunnable JavaEE.Main thread " + i);
        }

    }
}
