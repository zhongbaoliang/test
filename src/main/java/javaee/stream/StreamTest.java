package javaee.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
/*
*Stream 特性
* 1. Stream不会存储元素
* 2. 不会改变原对象，只会返回一个具有返回结果的Stream流；只能执行一次中间操作（但可以多个）
* 3. Stream操作是一个延时操作。多个中间操作连起来呢形成流水线，中间操作不会提前执行任何处理，在执行终止操作时一次性处理全部
*
* Stream的三个操作步骤
* 一. 创建Stream
*   1.通过collection集合提供的成员方法 stream()和parallelStream()获取流
*   2.通过Arrays中的静态方法 stream()获取流
*   3.通过Stream类中的静态方法of()获取流
*   4.通过Stream类中的静态方法iterate()迭代 创建无限流
*   5.通过Stream类中的静态方法generate()生成 创建无限流
* 二. 中间操作
* 筛选切片
*   1.limit()
*   2.filter()
*   3.skip()
*   4.distinct()
* 映射
*   1.map()
*   2.flatMap()
*
* 三. 终止操作
* collect
* count
* min
* max
* reduce
*
* */
class Employee{
    int Id;
    String name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(int id, String name) {
        Id = id;
        this.name = name;
    }
}

public class StreamTest {
    @Test
    public void createStream(){
        System.out.println("1. Arrays.stream 创建并执行skip筛选");
        String strs[]={"wang","lao","ban","a","a"};
        Stream<String> stream1=Arrays.stream(strs);
        stream1.skip(3).forEach(System.out::println);

        System.out.println("--------------");
        System.out.println("2. Collection.stream 创建并执行filter筛选");

        List<String> list=Arrays.asList(strs);
        Stream<String> stream2=list.stream();
        stream2.filter((s)->!"a".equals(s)).forEach((s)-> System.out.println(s));

        System.out.println("--------------");
        System.out.println("3. Stream.of 创建并执行distinct筛选");


        Stream<String > stream3=Stream.of("wang","lao","ban","a","a");
        stream3.distinct().forEach(System.out::println);

        System.out.println("--------------");
        System.out.println("4. Stream.iterate 创建并执行limit筛选");

        Stream<Integer> stream4=Stream.iterate(0,(i)-> {
            return i++;
        });
        stream4.limit(2).forEach(System.out::println);

        System.out.println("--------------");
        System.out.println("5. Stream.generate 创建并执行limit筛选");
        Stream<Integer> stream5=Stream.generate(()->{
            return (int) Math.random()*10;
        });
        stream5.limit(3).forEach(System.out::println);


    }

    //1. 可以通过Collection系列集合提供的stream()和parallelStream()方法获取流
    @Test
    public void test1(){
        List<String > list=Arrays.asList("wang","lao","ban");
        Stream<String> stream1 = list.stream().map((s1)->s1.toUpperCase());
        stream1.forEach(System.out::println);
    }

    //2. 通过Arrays中的静态方法stream()方法获取数组流
    @Test
    public void test2(){
        Employee[] employees= {new Employee(12,"wang"),
                new Employee(22,"huang"),
                new Employee(32,"zhou"),
                new Employee(42,"zhong"),
                new Employee(52,"lv"),
                new Employee(62,"liang"),
                new Employee(72,"shao")
        };
        Stream<Employee> stream2= Arrays.stream(employees);
        stream2.map(Employee::getName).forEach(System.out::println);
    }

    //3. 通过Stream类中的静态方法of()
    @Test
    public void test3(){
        Stream<String> stream3=Stream.of("aa","bb","cc");
        stream3.filter((s3)->!"bb".equals(s3)).forEach(System.out::println);
        /*下面两行代码不等同于上行代码，原因是stream流只能执行一次中间操作
        * stream3.filter((s3)->!"bb".equals(s3));
        * stream3.forEach(System.out::println);
        * */
    }

    @Test
    public void test41(){
        //4. 创建无限流
        //4.1 迭代
        Stream stream4=Stream.iterate(1,(x)->x+2);
        //两种写法相同
        //stream4.forEach((x)->System.out.println(x));
        //stream4.forEach(System.out::println);
        stream4.limit(10).forEach(System.out::println);
        int a=Integer.MAX_VALUE;
        int ans= Stream.iterate(1, x -> x + 1).limit(100).mapToInt(x -> x).sum();

    }

    @Test
    public void test42(){
        //4.2 生成
        Stream stream5=Stream.generate(()->(int)(Math.random()*10));
        stream5.limit(10).forEach(System.out::println);
    }
}
