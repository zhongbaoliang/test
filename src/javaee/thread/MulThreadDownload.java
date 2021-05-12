package javaee.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
//多线程下载图片
public class MulThreadDownload extends Thread{
    private String url;//网络图片地址
    private String name;//保存文件名

    public MulThreadDownload(String name, String url) {
        this.name=name;
        this.url = url;
    }

    @Override
    public void run(){
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为： "+name);
    }


    public static void main(String[] args) {
        MulThreadDownload mulThreadDownload1=new MulThreadDownload("1.jpg","https://www.kuangstudy.com/assert/course/c1/01.jpg");
        MulThreadDownload mulThreadDownload2=new MulThreadDownload("2.jpg","https://www.kuangstudy.com/assert/course/c1/02.jpg");
        MulThreadDownload mulThreadDownload3=new MulThreadDownload("3.jpg","https://www.kuangstudy.com/assert/course/c1/03.jpg");

        mulThreadDownload1.start();
        mulThreadDownload2.start();
        mulThreadDownload3.start();

    }
}
class WebDownloader{
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}