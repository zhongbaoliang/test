package javaee.thread.threadlocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//ThreadLocal
//线程私有
//
//PageHelper
//private static final ThreadLocal<?> THREAD_LOCAL
//ThreadLocal里面有ThreadLocal.ThreadLocalMap静态内部类，
// ThreadLocalMap里面有一个Entry数组，
// ThreadLocalMap.Entry的一个key保存的是一个ThreadLocal的弱引用
//ThreadLocalMap.Entry的一个value保存的是一个ThreadLocal的值



public class ThreadLocalTest1 {
    public static void testSubmit(){
        ExecutorService executorService= Executors.newFixedThreadPool(20);
        Future<Boolean> futures[]=new Future[20];
        for (int i = 0; i < 20; i++) {
            futures[i]= (Future<Boolean>) executorService.submit(new Thread(()->{
                System.out.println(DateUtilNotSafe.parse("2021-05-17 13:41:30"));
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
        executorService.shutdown();
    }

    public static void testExecuteNotSafe(){
        ExecutorService executorService= Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
           executorService.execute(new Thread(()->{
                System.out.println(DateUtilNotSafe.parse("2021-05-17 13:41:30"));
            }));
        }
        executorService.shutdown();
    }

    public static void testExecuteSafe(){
        ExecutorService executorService= Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Thread(()->{
                System.out.println(DateUtilSafe.parse("2021-05-17 13:41:30"));
            }));
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        testExecuteNotSafe();
        //testExecuteSafe();
    }
}

class DateUtilNotSafe{
    private static  final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Date parse(String  dateStr){
        Date date=null;
        try {
            date=sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}

class DateUtilSafe{
    private static final ThreadLocal<DateFormat> THREAD_LOCAL=ThreadLocal.withInitial(
            ()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    );
    //private static  final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Date parse(String  dateStr){
        Date date=null;
        try {
            date=THREAD_LOCAL.get().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
