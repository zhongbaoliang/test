package javaee.collections;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {

        int arrs[]=new int[10];
        ArrayList<Integer> arr=new ArrayList(Arrays.asList(arrs)) ;
        arr.set(0,2);
        List<List<Integer>> lists=new ArrayList<>();
        arr.get(5);


    }
    public static int[] listToArray(){
        ArrayList<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(list.size()-1);
        return list.stream().mapToInt(k->k).toArray();
    }
    public static  void linkedList(){
        LinkedList<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(0,2);
        list.addFirst(6);
        List<Integer>list1=new LinkedList<>(list);

        //Deque<Integer> deque = new LinkedList<>();


    }

    public static void arrayTest(){
        int arr[]=new int[10];
        int subArr[]=Arrays.copyOfRange(arr,2,6);

    }



}