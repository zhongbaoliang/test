package javaee.jvm.reflection.annotation;

import org.junit.Test;

import java.lang.annotation.*;

public class AnnotationTest {

    @Test
    @MyAnnotation(age=123)//变量名为value可以省略
    public void test()
    {

    }

}

//注解：对程序做出一些解释，可以被其他程序读取
//四大元注解meta-annotation：负责解释其他注解的注解
//@Target       描述注解的适用范围
//@Retention    描述注解的生命周期 SOURCE CLASS RUNTIME
//@Documented   说明该注解将被包含在javadoc
//@Inherited    说明子类可以继承父类的注解

@Target({ElementType.TYPE,ElementType.METHOD})//
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    //注解参数：参数类型+参数名();
    String name() default "";
    int age();
    int id() default -1;//如果默认值为-1，代表不存在
    String[] schools() default {"武","汉","大","学"};
}