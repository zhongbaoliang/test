package javaee.tools.OOPTest;

public class Outer {
    //public static Object Inner1;
    private int id =2021;
    public void out(){
        System.out.println("外部类方法！");
    }

    //成员内部类
    class Inner1{
        public void in(){
            System.out.println("成员内部类方法！");
            System.out.println(Integer.toString(id) + "成员内部类可以访问父类非静态属性");
        }
    }
    //静态内部类
    static class Inner2{
        public static void in2_1(){
            System.out.println("静态内部类静态方法！");
        }
        public void in2_2(){
            System.out.println("静态内部类非静态方法！");

        }
    }
}
class Test{
    public static void main(String args[]){

        Outer outer=new Outer();
        Outer.Inner1 inner1=outer.new Inner1();//奇葩的 外部类.new
        //本地内部类
        class Inner3{
            //没有静态方法
            public void in2_2(){
                System.out.println("静态内部类非静态方法！");
            }
        }
        inner1.in();
        Outer.Inner2.in2_1();

    }
}
