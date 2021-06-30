package javaee.oop.Generics;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

//泛型通配符
//解决泛型作为参数只能传递一种
public class WildCard {
    public static double addOne(Number number){
        return (0.1+number.doubleValue());
    }

    //不用通配符，只能传Number类型
    public static double sumOfList(List<Number> list){
        double s=0.0;
        for (Number number : list) {
            s+= number.doubleValue();
        }
        return s;
    }


    //使用上限通配符，可以传Number及其子类
    public static double sumOfList1(List<? extends Number> list){
        //ArrayQueue<Integer> queue= new ArrayQueue<Integer>(6);
        double s=0.0;
        for (Number number : list) {
            s+= number.doubleValue();
        }
        return s;
    }

    //使用无限通配符，可以传Object及其子类
    public static double sumOfList2(List<?> list){
        //ArrayQueue<Integer> queue= new ArrayQueue<Integer>(6);
        double s=0.0;
        for (Object number : list) {
            s+= ((Number)number).doubleValue();
        }
        return s;
    }

    public static void main(String[] args) {
        Integer integer=6;
        System.out.println(addOne(integer));
        List<Integer> IntL= Arrays.asList(1,2,3);
        //System.out.println(sumOfList(IntL));
        System.out.println(sumOfList1(IntL));
        System.out.println(sumOfList2(IntL));

        System.out.println("*****************");
        System.out.println(addOne(6.6));
        LinkedList<Double> DblL=new LinkedList<>(Arrays.asList(1.1,2.2,3.3));
        //System.out.println(sumOfList(DblL));
        System.out.println(sumOfList1(DblL));
        System.out.println(sumOfList2(DblL));

    }
}
