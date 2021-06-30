package javaee.thread.functions;

//排队 join
//Thread的成员方法
// t.join();
// 子线程执行完才继续执行父线程
public class JoinTest implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("线程vip来了 " +i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest=new JoinTest();
        Thread thread=new Thread(joinTest);
        thread.start();
        for (int i = 0; i < 50; i++) {
            if(i==20){
                thread.join();
            }
            System.out.println("main "+i);
        }
    }
}
