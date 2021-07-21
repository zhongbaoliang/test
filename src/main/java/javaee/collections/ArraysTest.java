package javaee.collections;

import org.junit.Test;

import java.util.Arrays;

public class ArraysTest {
    @Test
    public void test01(){
        int a[]=new int[10];
        for(int i=0;i<10;i++)
            a[i]=10-i;
        int[] b= Arrays.copyOfRange(a,0,10);
        b[5]=-1;
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : b) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
