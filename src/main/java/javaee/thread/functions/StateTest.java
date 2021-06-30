package javaee.thread.functions;
//线程状态 Thread.State为枚举类型，
// 有六种状态；
// 1. NEW 新建态；调用线程的start方法之前

// 2. RUNNABLE 可运行态；包括 RUNNING,READY；
// 2.1 READY 就绪态，NEW状态时调用t.start()后 或者
// RUNNING状态时调用Thread.yield()，Thread.sleep(),t.join()；等待CPU资源,
// 2.1 RUNNING 运行态；READY状态时获得了CPU资源

// 3. BLOCKED 阻塞态；线程阻塞于锁；线程等待进入synchronized方法或代码块

// 4. WAITING 等待态；无限期等待其他线程通知；
// 5. TIMED_WAITING 超时等待；等待其他线程通知 或 等待指定时间

// 6. TERMINATED 终止态；线程已经执行完毕，不能再调用t.start()

// t.getState()获取子线程状态
public class StateTest {
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("///////");
            }
        });


        thread.start();
        Thread.State state=thread.getState();
        System.out.println(state);
        //Thread.State.
        while(state!=Thread.State.TERMINATED){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(state);
            state=thread.getState();
        }
    }
}
