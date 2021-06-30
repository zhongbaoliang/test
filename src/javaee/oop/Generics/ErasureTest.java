package javaee.oop.Generics;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

//无限制类型擦除
//用Object替换了T，可接受所有类型
class Erasure<T> {
    T key;
    String val;
    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public <T> T get(T t){
        return t;
    }

    public <T extends List> T show(T t){
        return t;
    }
}
//有限制类型擦除
//用父类替换T,可接受父类及其子类
class Erasure1<T extends Number>{
    public T key;
    String val;
    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T get(T t){
        return t;
    }

    public <T extends List> T show(T t){
        return t;
    }
}

public  class ErasureTest{
    public static void main(String[] args) {
        Erasure<Integer> erasure=new Erasure<>();
        Class<? extends Erasure> cls = erasure.getClass();//获取Erasure类的字节码文件的Class类对象
        //System.out.println(cls.getName()+" "+cls.getClass());
        Field[] declareField=cls.getDeclaredFields();//获取所有成员变量
        for (Field field : declareField) {
            //成员变量名称及其类型
            System.out.println(field.getName()+" "+field.getType().getSimpleName());
        }

        System.out.println("**********************************");

        Method[] declareMethod=cls.getDeclaredMethods();
        for (Method method : declareMethod) {
            System.out.println(method.getName()+" "+method.getReturnType().getSimpleName());
        }
    }
}
