package javaee;

import javaee.thread.newThread.ExtendsThread;

public class Main {
    public static void main(String arg[]){
        ExtendsThread extendsThread = new ExtendsThread(10);
        extendsThread.start();
        for(int i=0;i<10;i++)
            System.out.println("Hello ,i am helloCode " + i);
    }
}