package javaee.thread.syntronized.safe;

public class TwoThread  {
    public static void main(String[] args) {
        final Object object = new Object();
        new Thread(()->{
            for (int i = 0; i <= 9; i+=2) {
            synchronized (object) {
                object.notify();
                System.out.println(Thread.currentThread().getName() + "：" + i);
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        }).start();
        new Thread(()->{
            for (int i = 1; i <= 9; i+=2) {
                synchronized (object) {
                    object.notify();
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start(); ;
    }

}