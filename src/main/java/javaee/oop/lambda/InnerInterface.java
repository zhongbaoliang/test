package javaee.oop.lambda;

//四大内置函数型接口
//Consumer<T> 消费型接口
//      void accept(T t)
//Supplier<T> 供给型接口
//      T get()
//Function(T,R) 函数型接口
//      R apply(T t)
//Predicate<T> 断言型接口
//      boolean test(T t)

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InnerInterface {
    @Test
    public void test4(){
        List<String> list= Arrays.asList("wang","lao","ban");
        List<String> stringList=new ArrayList<>();
        //两种写法等价
        Predicate<String> predicate=(str)-> {
            return str.length()>3;
        };
        Predicate<String> predicate1=(str)->str.length()>3;
        for (String s : list) {
            if(predicate.test(s))
                stringList.add(s);
        }
        for (String s : stringList) {
            System.out.println(s);
        }
    }



    @Test
    public void test1(){
        Double d=3.2;
        Consumer<Double> consumer= (aDouble)->{
                System.out.println("赚了"+aDouble+"元");
            };

        //不能这么写，Thread可以是因为Thread是一个类，并且有Runnable接口的属性（静态代理）
        /*new Consumer<Double>((a)->{
            System.out.println("外快"+a+"元");
        }).accept(5000.0);*/

        Consumer<Double> consumer1=new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("存了"+aDouble+"元");
            }
        };


        consumer.accept(3000.0);
        consumer1.accept(2000.0);

        //lambda表达式作为参数！
        testConsumer(1000.0,(m)-> System.out.println("花了"+m+"元"));
    }
    public void testConsumer(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }



}
