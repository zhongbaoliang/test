package javaee.oop.extendsTest;
//先构造父类，再构造子类
//先析构子类，再析构父类
//属性是父类的，方法是子类的
// 子类中使用的属性是子类的
//自我解释，最近原则
public class Son extends Father{
    public int a;
    public Son(int key,int val){
        super(key,val);//子类构造函数里面必须调用父类构造函数(显式隐式），并且在第一行调用
        this.a=a+b+1;//因为子类的构造函数中可以调用父类成员
    }
    public void test1(){
        System.out.println("son " + a);//子类中使用的属性是子类的
    }


    public static void main(String[] args) {
        Father person = new Son(1,1);
        System.out.println("person " + person.a);//子类与父类有相同名称的属性，则是父类的属性
        person.test1();//子类与父类有相同名称的方法，则执行子类的方法
    }
}
