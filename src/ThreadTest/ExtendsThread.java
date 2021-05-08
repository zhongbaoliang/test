package ThreadTest;
public class ExtendsThread extends Thread{
    long minPrime;
    public ExtendsThread(long minPrime){
        this.minPrime=minPrime;
    }
    public void run(){
        for(int i=0;i<minPrime;i++)
            System.out.println("hello, i am minPrime " + i);
    }
}