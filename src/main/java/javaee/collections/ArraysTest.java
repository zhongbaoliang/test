package javaee.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysTest {
    @Test
    public void test01(){
        int a[]=new int[10];
        Arrays.fill(a,1);
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
        String str[]=new String[10];
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String x, String y){

                return 0;
            }
        });

        int[][] Arr2_1 = new int[5][6];
        int[][] Arr2_2 = Arrays.copyOfRange(Arr2_1,0,5);
        int[][] Arr2_3 = new int[3][];
    }

}
