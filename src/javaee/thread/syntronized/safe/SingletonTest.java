package javaee.thread.syntronized.safe;


public class SingletonTest {
    public static void main(String[] args) {
        System.out.println(Singleton4.ONE);
    }
}
//饿汉模式  多线程安全
//通过反射可以创建多个对象
class Singleton1{
    private static Singleton1 instance=new Singleton1();
    private Singleton1(){}

    public static Singleton1 getInstance(){
        return instance;
    }
}

//懒汉模式
class Singleton2{
    private static Singleton2 instance =null;
    private Singleton2(){}
    public static Singleton2 getInstance(){
        if(instance==null)
            instance=new Singleton2();
        return instance;
    }
}

//懒汉模式 双检锁
class Singleton3{
    //private static Singleton3 instance;
    private volatile static Singleton3 instance;
    private Singleton3(){}

    public static Singleton3 getInstance(){
        if(instance==null){
            synchronized (instance){
                if(instance==null)
                    instance=new Singleton3();
            }
        }
        return instance;
    }
}

//枚举类型
//解决了反射创建对象问题
enum Singleton4{
    ONE;

}

