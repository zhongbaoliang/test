package javaee.thread.functions;

//线程优先级
//优先级高的不一定先执行
//先设置优先级再启动
//getPriority()
//setPriority(int xxx);xxx范围1-10,最小为1，最大为10,默认为5，大于10或者小于1时会报错
public class PriorityTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"优先级为 "+Thread.currentThread().getPriority());

        MyPriority myPriority=new MyPriority();
        Thread thread0=new Thread(myPriority);
        Thread thread1=new Thread(myPriority);
        Thread thread2=new Thread(myPriority);
        Thread thread3=new Thread(myPriority);
        Thread thread4=new Thread(myPriority);
        Thread thread5=new Thread(myPriority);

        //先设置优先级再启动
        //thread1.setPriority(1);//不手动设置会自动设置优先级
        thread0.start();

        thread1.setPriority(2);
        thread1.start();

        thread2.setPriority(3);
        thread2.start();

        thread3.setPriority(4);
        thread3.start();

        //小于1或者大于10时运行时会报错
        //thread5.setPriority(0);
        thread4.start();

        //thread6.setPriority(11);
        thread5.start();

    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"优先级为 "+Thread.currentThread().getPriority());
    }
}