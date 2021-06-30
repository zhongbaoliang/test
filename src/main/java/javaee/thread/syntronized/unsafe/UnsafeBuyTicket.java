package javaee.thread.syntronized.unsafe;
//不安全的买票
public class UnsafeBuyTicket implements Runnable{
    private int ticketNums=10;
    boolean flag=true;

    @Override
    public void run() {
        //买票
        while(flag){
            buy();
        }

    }
    private void buy(){
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
        UnsafeBuyTicket unsafeBuyTicket=new UnsafeBuyTicket();
        Thread thread1=new Thread(unsafeBuyTicket);
        Thread thread2=new Thread(unsafeBuyTicket);
        Thread thread3=new Thread(unsafeBuyTicket);

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
