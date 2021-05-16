package javaee.thread.functions;
//线程休眠 sleep Thread的静态方法
//线程礼让 yield Thread的静态方法
//线程插队 join  Thread的成员方法
//线程等待 wait  Object的final方法
//线程状态 Thread.State为枚举类型，有五种状态；   t.getState()获取子线程状态
//


public class funcTest {


    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            System.out.println("hello");
        });

        thread.start();
        //thread.getState();
        //thread.stop();
    }
}
