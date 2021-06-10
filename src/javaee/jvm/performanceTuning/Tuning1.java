package javaee.jvm.performanceTuning;

import java.util.ArrayList;
import java.util.List;

public class Tuning1 {
    byte[] a = new byte[1024*100];//1kB
    public static void main(String[] args) throws InterruptedException {
        List<Tuning1> list=new ArrayList<>();
        while(true){
            list.add(new Tuning1());
            Thread.sleep(10);
        }
    }
}
