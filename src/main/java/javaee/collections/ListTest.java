package javaee.collections;

import org.junit.Test;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {

        int arrs[]=new int[10];
        ArrayList<Integer> arr=new ArrayList(Arrays.asList(arrs)) ;
        arr.set(0,2);
        List<List<Integer>> lists=new ArrayList<>();
        int[][] objects = lists.toArray(new int[lists.size()][2]);
        arr.get(5);//越界异常
        Integer[] ans1 = (Integer[]) arr.toArray();
        int[] ans2 = arr.stream().mapToInt(x->x).toArray();
        int[] ans3 = arr.stream().mapToInt((x)->{return x;}).toArray();
    }
    public static int[] listToArray(){
        List<Integer>list=new LinkedList<>();
        list.add(1);
        list.add(2);

        list.remove(list.size()-1);

        Integer ints[]=list.toArray(new Integer[list.size()]);
        return list.stream().mapToInt(k->k).toArray();

    }
    @Test
    public  void linkedList(){
        LinkedList<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(0,2);
        list.addFirst(6);
        list.size();
        for (Integer integer : list) {
            System.out.println(integer);
            list.remove(integer);//不能改，抛异常
            integer=0;
        }
        list.clone();
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = (Integer) iterator.next();
            System.out.println(integer);
            iterator.remove();//删除
            integer=1;
        }
        System.out.println("list size "+list.size());


        List<Integer>list1=new LinkedList<>(list);

        List<int[]> list2 = new LinkedList<int[]>(){
            {
                add(new int[]{1, 2});
            }
        };

        //Deque<Integer> deque = new LinkedList<>();


    }

    public static void arrayTest(){
        int arr[]=new int[10];
        int subArr[]=Arrays.copyOfRange(arr,2,6);

    }



}
