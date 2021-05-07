package thread;

public class threadTest {
    public static void main(String arg[]){
        PrimeThread primeThread = new PrimeThread(10);
        primeThread.run();
        for(int i=0;i<10;i++)
            System.out.println("Hello ,i am helloCode " + i);
    }
}
