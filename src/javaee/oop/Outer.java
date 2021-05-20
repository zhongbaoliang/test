package javaee.oop;
//内部类

//成员内部类，静态内部类，局部内部类（本地内部类），匿名内部类
//成员内部类没有静态方法；成员内部类的 成员方法可以访问外部类的属性、静态属性、方法、静态方法；
//静态内部类的成员方法和静态方法都只能访问外部类的静态属性和静态方法
//本地内部类没有静态方法；本地内部类可以访问外部的变量，但不能改变
//匿名内部类 new Runnable(){
//            @Override
//            public void run() { }
//         };
public class Outer {
    //public static Object Inner1;
    private String outStaticVar ="外部类成员属性";
    public void outStaticMethod(){
        System.out.println("外部类成员方法！");
    }

    public static void outMethod(){
        System.out.println("外部类静态方法");
    }
    private static String outVar="外部类静态属性";

    //1. 成员内部类
    class Inner1{
        public void in1_1(){
            //可以访问外部的属性、静态属性、方法、静态方法
            outStaticVar="成员内部类";
            outVar="成员内部类";
            outStaticMethod();
            outMethod();
            System.out.println("成员内部类的成员方法可以访问外部类的属性、静态属性、方法、静态方法！");
            //System.out.println(Integer.toString(id) + "成员内部类可以访问父类非静态属性");
        }
       /* public static void in1_2(){
            //成员内部类不能有静态方法

        }*/
    }
    //2. 静态内部类
    static class Inner2{
        public static void in2_1(){
            //outStaticVar="静态内部类";
            outVar="静态内部类";
            //outStaticMethod();
            outMethod();
            System.out.println("静态内部类的静态方法只能访问外部类的静态属性和静态方法！");
        }
        public void in2_2(){
            //outStaticVar="静态内部类";
            outVar="静态内部类";
            //outStaticMethod();
            outMethod();
            System.out.println("静态内部类的成员方法只能访问外部类的静态属性和静态方法！");

        }
    }
}
class Test{
    public static void main(String args[]){

        Outer outer=new Outer();
        Outer.Inner1 inner1=outer.new Inner1();//奇葩的 外部类.new

        int n=1;
        //3. 本地内部类,局部内部类
        class Inner3{


            /*public static voit in3_1(){
                //没有静态方法
            }*/
            public void in3_2(){
                //可以访问外部的变量，但不能改变
                //n++;//不能改变外部值
                System.out.println("静态内部类非静态方法！");
            }
        }
        n++;
        inner1.in1_1();
        Outer.Inner2.in2_1();

        //4. 匿名内部类
        new Runnable(){
            @Override
            public void run(){}
        };


    }
}
