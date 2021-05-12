package javaee.thread;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;


//创建线程方式三：
//自定义类 实现callable接口
//创建类示例
//
//创建线程池
//将类实例提交到线程池
//获取返回值
//关闭线程池
public class ImplementsCallable implements Callable {
    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为： "+name);
        return true;
    }

    private String url;//网络图片地址
    private String name;//保存文件名

    public ImplementsCallable(String name, String url) {
        this.name=name;
        this.url = url;
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ImplementsCallable t1=new ImplementsCallable("1.jpg","https://www.kuangstudy.com/assert/course/c1/01.jpg");
        ImplementsCallable t2=new ImplementsCallable("2.jpg","https://www.kuangstudy.com/assert/course/c1/02.jpg");
        ImplementsCallable t3=new ImplementsCallable("3.jpg","https://www.kuangstudy.com/assert/course/c1/03.jpg");

        //创建执行服务 ExecutorService ser= Executors.newFixedThreadPool(3);
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行 Future<Boolean> result1=ser.submit(t1);
        Future<Boolean> future1= ser.submit(t1);
        Future<Boolean> future2= ser.submit(t2);
        Future<Boolean> future3= ser.submit(t3);

        //获取结果  boolean res1=future1.get();
        boolean res1=future1.get();
        boolean res2=future2.get();
        boolean res3=future3.get();

        System.out.println("res1 "+res1);
        System.out.println("res2 "+res2);
        System.out.println("res3 "+res3);

        //关闭服务  ser.shutdownNow();
        ser.shutdownNow();

    }
}
