package javaee.thread;
//龟兔赛跑

public class TRRace implements Runnable{
    private static String winner;

    @Override
    public void run() {
        //100.for
        for (int i = 0; i <= 100; i++) {
            if(gameOver(i))
                break;
            if(i%10==0 && Thread.currentThread().getName()=="兔子") {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i+"米");

        }
    }

    private boolean gameOver(int steps){
        if(winner!=null){
            return true;
        }else {
            if(steps>=100){
                winner=Thread.currentThread().getName();
                System.out.println("winner is "+winner);
                return true;
            }
            else
                return false;
        }
    }

    public static void main(String[] args) {
        TRRace trRace=new TRRace();
        Thread thread=new Thread(trRace,"兔子");
        Thread thread1=new Thread(trRace,"乌龟");

        thread.start();
        thread1.start();
    }
}
