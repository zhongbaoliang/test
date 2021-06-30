package javaee.thread.pool;

//作用：重用已存在的线程，降低线程创建和销毁造成的消耗；
//新任务到来时:
//1. 判断核心线程池是否已满；若没有则创建线程并执行任务，否则
//2. 判断工作队列是否已满  ；若没有则放在工作队列队尾 ，否则
//3. 判断线程池是否已满；    若没有则为 工作队列队头任务 创建线程并执行；否则
//4. 执行拒绝策略

//主要参数
//corePoolSize 核心线程数  空闲也不会销毁，除非设置了allowCoreThreadTimeOut
//maximumPoolSize 线程池最大线程数  最多有maximumPoolSize个线程
//keepAliveTime 空闲线程存活时间（线程数量大于corePoolSize时
//unit 空闲线程存活时间单位
//workQueue 工作队列

//分类
//newCachedThreadPoll 无限个线程                     0,     Integer.MAX_VALUE,  60L, TimeUnit.SECONDS,       new SynchronousQueue<Runnable>()
//newFixedThreadPool 指定线程个数（定长）          nThreads,       nThreads,       0L, TimeUnit.MILLISECONDS,  new LinkedBlockingQueue<Runnable>()
//newSingleThreadExecutor  单个线程                  1,             1,           0L, TimeUnit.MILLISECONDS,  new LinkedBlockingQueue<Runnable>())
//new ScheduledThreadPool  定长；周期性执行任务 corePoolSize, Integer.MAX_VALUE,   0L,       NANOSECONDS,      new DelayedWorkQueue()

//newWorkStealingPool   可指定线程个数，也可以让JVM自适应创建，更有利于并发

//流程
//创建线程池
//将类实例提交到线程池
//获取返回值，submit时可有可无，execute没有这一步
//关闭线程池

//execute只能runnable，submit可提交runnable或callable
//execute会直接抛出异常，而submit需要通过Future.get()获取异常


import java.util.concurrent.*;

public class ThreadPoolTest {

    //newSingleThreadExecutor
    public static void test1(){
        ExecutorService executorService= Executors.newSingleThreadExecutor();
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

    //newFixedThreadPool
    //execute没有返回值,有任务未完成时直接抛出异常
    public static void test21(){
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Thread(()->{
                for(int ii=0;ii<100;ii++){
                    System.out.println(Thread.currentThread().getName()+" 运行 " + ii);
                }
            }));
        }
        //executorService.shutdownNow();//试图终止当前正在执行的任务
        executorService.shutdown();//执行完线程池里面的所有任务
    }
    //submit有返回值，.get()为null表示执行完成，便于进行异常处理
    public static void test22(){
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        Future<Boolean> futures[]=new Future[20];
        for (int i = 0; i < 20; i++) {
            futures[i]= (Future<Boolean>) executorService.submit(new Thread(()->{
                for(int ii=0;ii<100;ii++){
                    System.out.println(Thread.currentThread().getName()+" 运行 " + ii);
                }
            }));
        }
        for (int i = 0; i < 20; i++) {
            try {
                System.out.println("future "+i+" "+futures[i].get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                //对未完成的任务进行异常处理
                e.printStackTrace();
            }
        }

        //executorService.shutdownNow();//试图终止当前正在执行的任务
        executorService.shutdown();//执行完线程池里面的所有任务
    }

    //newCachedThreadPool
    public static void test3(){
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            executorService.submit(new Thread(()->{
                for(int ii=0;ii<100;ii++){
                    System.out.println(Thread.currentThread().getName()+" 运行 " + ii);
                }
            }));
        }
        //executorService.shutdownNow();//试图终止当前正在执行的任务
        executorService.shutdown();//执行完线程池里面的所有任务
    }

    //newScheduledThreadPool
    public static void test4(){
        ExecutorService executorService= Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executorService.submit(new Thread(()->{
                for(int ii=0;ii<100;ii++){
                    System.out.println(Thread.currentThread().getName()+" 运行 " + ii);
                }
            }));
        }
        //executorService.shutdownNow();//试图终止当前正在执行的任务
        executorService.shutdown();//执行完线程池里面的所有任务
    }

    //newWorkStealingPool
    //充分利用CPU，采用分治思想
    //可指定线程数，不指定时JVM根据本机内核线程数创建
    //每个线程都有一个LIFO的工作队列
    //当有线程空闲时会窃取其他线程的工作队列尾部任务
    //窃取发生冲突时采用CAS解决
    //
    // 创建的是守护线程，主线程需要等守护线程结束
    // 任务被乱序执行
    public static void test5() throws ExecutionException, InterruptedException {
        int threads = 10;
        // 用于计数线程是否执行完成
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        ExecutorService executorService=Executors.newWorkStealingPool();
        for (int i = 0; i < threads; i++) {
            //都是守护线程，wt.setDaemon(true);
            executorService.execute(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }));
        }
        countDownLatch.await();
        System.out.println("---- end ----");
    }

    public static void main(String[] args){
        try {
            test5();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
