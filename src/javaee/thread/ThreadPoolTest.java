package javaee.thread;

//作用：重用已存在的线程，降低线程创建和销毁造成的消耗；
//新任务到来时:
//1. 判断核心线程池是否已满；若没有则创建线程并执行任务，否则
//2. 判断工作队列是否已满  ；若没有则放在工作队列队尾 ，否则
//3. 判断线程池是否已满；    若没有则为 工作队列队头任务 创建线程并执行；否则
//4. 执行拒绝策略

//分类
//newCachedThreadPoll 无限个线程
//newFixedThreadPool 指定线程个数（定长）
//newSingleThreadExecutor  单个线程
//new ScheduledThreadPool  定长；周期性执行任务

//主要参数
//corePoolSize 核心线程数  空闲也不会销毁，除非设置了allowCoreThreadTimeOut
//maximumPoolSize 线程池最大线程数  最多有maximumPoolSize个线程
//keepAliveTime 空闲线程存活时间（线程数量大于corePoolSize时
//unit 空闲线程存活时间单位
//workQueue 工作队列

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        executorService.execute(new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println(Thread.currentThread().getName()+" 运行 " + i);
            }
        }));

        executorService.execute(new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println(Thread.currentThread().getName()+" 运行 " + i);
            }
        }));


        //executorService.shutdownNow();//试图终止当前正在执行的任务
        executorService.shutdown();//执行完线程池里面的所有任务
    }
}
