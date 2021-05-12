package javaee.thread;

import javaee.thread.newThread.ExtendsThread;

//匿名函数，lambda，线程池
//两个线程交替执行
public class ThreadTest {
    public static void main(String arg[]){
        ExtendsThread extendsThread = new ExtendsThread(10);
        extendsThread.start();
        for(int i=0;i<10;i++)
            System.out.println("Hello ,i am helloCode " + i);
    }
}

