package javaee.stream;

import java.util.ArrayList;
import java.util.List;
//采用ForkJoinPool思想
//自适应创建线程数
//分治
//窃取
//乱序执行

public class ParallelStreamTest {
    /**
     * 构造数据
     *
     * @return
     */
    List<Person> persons;
    public void constructPersons() {

        persons = new ArrayList<Person>();
        for (int i = 0; i < 5; i++) {
            Person p = new Person(i, "name" + i, "sex" + i, i);
            persons.add(p);
        }
    }

    /**
     * for
     *
     * @param
     */
    public void doFor() {
        long start = System.currentTimeMillis();

        for (Person p : persons) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(p.name);
        }

        long end = System.currentTimeMillis();
        System.out.println("doFor cost:" + (end - start));
    }

    /**
     * 顺序流
     *
     * @param
     */
    public void doStream() {
        long start = System.currentTimeMillis();

        persons.stream().forEach(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(x.name);
        });

        long end = System.currentTimeMillis();
        System.out.println("doStream cost:" + (end - start));
    }

    /**
     * 并行流
     *
     * @param
     */
    public void doParallelStream() {

        long start = System.currentTimeMillis();

        persons.parallelStream().forEach(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(x.name);
        });

        long end = System.currentTimeMillis();

        System.out.println("doParallelStream cost:" + (end - start));
    }

    public static void main(String[] args) {
        ParallelStreamTest parallelStreamTest=new ParallelStreamTest();
        parallelStreamTest.constructPersons();
        parallelStreamTest.doFor();
        parallelStreamTest.doStream();
        parallelStreamTest.doParallelStream();
    }
}

class Person {
    int    id;
    String name;
    String sex;
    float  height;

    public Person(int id, String name, String sex, float height) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.height = height;
    }
}