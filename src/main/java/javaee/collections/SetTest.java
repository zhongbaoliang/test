package javaee.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println(set.size());
        for (Integer integer : set) {

        }



        Set<Integer> set1 = new TreeSet<>();
        set1.add(1);
        for(Integer i : set1){

        }
        set1.add(1);
        System.out.println(set1.size());
    }

}
