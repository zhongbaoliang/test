package ThreadTest;

public class ImplementsRunnable implements Runnable {
    long data = 10;

    public ImplementsRunnable(long data) {
        this.data = data;
    }

    @Override
    public void run(){
        for(int i=0;i<data;i++){
            System.out.println("Hello, i am ImplementsRunnable sub thread " + i);
        }
    }

    public static void main(String arg[]){
        ImplementsRunnable implementsRunnable =new ImplementsRunnable(10);
        Thread thread =new Thread(implementsRunnable);
        thread.start();

        for(int i=0;i<10;i++){
            System.out.println("Hello, i am ImplementsRunnable Main thread " + i);
        }

    }
}
