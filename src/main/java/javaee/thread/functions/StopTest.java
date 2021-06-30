package javaee.thread.functions;

//停止线程
//推荐让线程自行停止
//建议线程 利用循环次数 正常停止，不建议死循环
//建议使用一个标志位进行终止
//不推荐使用JDK的stop()、destroy()方法

//eg: flag=false时,则终止线程运行。


//线程休眠 sleep Thread的静态方法
//线程礼让 yield Thread的静态方法
//线程排队 join  Thread的成员方法
//线程    wait  Object的final方法

//
public class StopTest implements Runnable{
    private boolean flag = true;

    @Override
    public void run() {
        int i=0;
        while(flag)
            System.out.println("thread "+Thread.currentThread().getName()+" run "+i++);
    }


    public void stop(){
        this.flag=false;
    }


    public static void main(String[] args) {

        StopTest stopTest=new StopTest();
        Thread thread1=new Thread(stopTest);
        //thread1.stop();
        thread1.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("thread "+Thread.currentThread().getName()+" run "+i);
            if(i==900) {
                System.out.println("子线程结束");
                stopTest.stop();

            }
        }
    }

}
