package ThreadTest;

public class ThreadTest {
    public static void main(String arg[]){
        ExtendsThread extendsThread = new ExtendsThread(10);
        extendsThread.start();
        for(int i=0;i<10;i++)
            System.out.println("Hello ,i am helloCode " + i);
    }
}