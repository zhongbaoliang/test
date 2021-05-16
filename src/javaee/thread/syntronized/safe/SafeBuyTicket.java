package javaee.thread.syntronized.safe;

//同步方法 public synchronized void buy(){}
//同步代码块 synchronized(Obj){}
//Obj称之为同步监视器

public class SafeBuyTicket implements Runnable{
    private int ticketNums=10;
    boolean flag=true;

    @Override
    public void run() {
        //买票
        while(flag){
            buy();
        }

    }
    private synchronized void buy(){
        if(ticketNums<=0){
            flag=false;
            return;
        }
        //this
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 买到了 " + ticketNums--);

    }


    public static void main(String[] args) {
        SafeBuyTicket buyTicket=new SafeBuyTicket();
        Thread thread1=new Thread(buyTicket);
        Thread thread2=new Thread(buyTicket);
        Thread thread3=new Thread(buyTicket);

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
