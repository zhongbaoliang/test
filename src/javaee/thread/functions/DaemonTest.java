package javaee.thread.functions;

//线程分为用户线程和守护线程
//虚拟机必须保证用户线程执行完毕
//虚拟机不用等待守护线程执行完毕，虚拟机关闭时守护线程才结束
//eg 后台记录操作日志，监控内存，垃圾回收等待
public class DaemonTest {
    public static void main(String[] args) {
        God god=new God();
        You you=new You();
        Thread thread=new Thread(god);
        thread.setDaemon(true);
        thread.start();

        new Thread(you).start();
    }
}
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("你活了"+i+"年");
        }
        System.out.println("----------你死了---------");
    }
}
class God implements Runnable{
    @Override
    public void run(){
        while(true)
            System.out.println("上帝永生");
    }
}