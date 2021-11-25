package javaee.oop;


//内部类
//要解决一个较为复杂的问题，创建一个类来辅助实现，但是不希望这个类是公共可用的。
//内部类同时也是Java多继承的一种实现方式，每个内部类都能实现多个接口或者继承一个类

/**
 * 非静态内部类：成员内部类、局部内部类、匿名内部类都：
 *  1. 持有外部类实例的引用，因此其创建依赖于外部类实例
 *  2. 可以无限制的访问和 **修改** 外部类的所有成员属性方法
 *  3. 不能有静态成员（属性和方法）。
 *    因为假如有的话，就可以在内部类的静态方法中直接调用外部类的方法，而此时外部类尚未创建实例。
 *  4. 非静态内部类依赖于外部类，只有创建了外部类，才能创建非静态内部类
 */


//分类：成员内部类，静态内部类，局部内部类（本地内部类），匿名内部类
// 成员内部类 非静态内部类4大特点。
// 本地内部类 非静态内部类4大特点；可以访问外部函数的变量，但不能改变。
// 匿名内部类 非静态内部类4大特点；没有名字，只使用一次，没有构造函数；可以通过接口、抽象类、类来实现。
// 静态内部类 没有外部类的引用，因此他的创建不需要依赖于外部内的实例。静态内部类的成员方法和静态方法都只能访问外部类的静态属性和静态方法。
// new Runnable(){
//            @Override
//            public void run() { }
//         };
public class Outer {
    //public static Object Inner1;
    private String outVar ="外部类成员属性";
    private void outMethod(){
        System.out.println("外部类成员方法！");
    }

    private static void outStaticMethod(){
        System.out.println("外部类静态方法");
    }
    private static String outStaticVar="外部类静态属性";

    /**1. 成员内部类
     *  成员内部类是外部类的一个成员
     *  因此（像成员方法一样）持有外部类实例的引用，因此其创建依赖于外部类实例
     *  他可以无限制的访问和 **修改** 外部类的所有成员属性方法
     *  成员内部类不能有静态成员（属性和方法）。
     *      因为假如有的话，就可以在内部类的静态方法中直接调用外部类的方法，而此时外部类尚未创建实例。
     *  成员内部类依赖于外部类，只有创建了外部类，才能创建成员内部类
     *
     *  会产生内存泄漏问题
     */
    class Inner1 extends Test{
        public void in1_1(){
            //this.outMethod();
            //可以访问外部的属性、静态属性、方法、静态方法
            outStaticVar="外部内的静态属性";
            outVar="外部内的成员属性";
            outStaticMethod();
            outMethod();
            System.out.println("成员内部类的成员方法可以访问外部类的属性、静态属性、方法、静态方法！");
            System.out.println();
            //System.out.println(Integer.toString(id) + "成员内部类可以访问父类非静态属性");
        }
       /* public static void in1_2(){
            //成员内部类不能有静态方法

        }*/
    }

    /**2. 静态内部类
     * 没有外部类实例的引用，其创建也就不需要依赖于外部类实例
     * 可以有静态方法和成员方法
     * 只能访问外部内的静态成员
     */
    static class Inner2 extends Test{
        public static void in2_1(){
            outStaticVar="外部类静态属性";
            //outVar="静态内部类";
            outStaticMethod();
            //outMethod();
            System.out.println("静态内部类的 静态方法 只能访问外部类的静态属性和静态方法！");
        }
        public void in2_2(){
            outStaticVar="外部类静态属性";
            //outVar="静态内部类";
            outStaticMethod();
            //outMethod();
            System.out.println("静态内部类的 成员方法 只能访问外部类的静态属性和静态方法！");
            System.out.println();


        }
    }


    /**3. 本地内部类,局部内部类
     * 有成员内部类的所有特性
     * 但是其作用域只是 当前方法
     * ***其方法只能访问外部函数的变量，而 **不能对其进行修改** ***
     *
     */
    public void func1OfOuter(){
        StringBuilder var=new StringBuilder("局部内部类 所在的函数中的局部变量");
        class Inner3 extends Test{
            /*public static voit in3_1(){
                //没有静态方法
            }*/

            public void in3_2(){
                System.out.println(var);//可以访问外部的变量
                //this.outMethod();
                //var="函数局部变量";//但不能改变
                outStaticVar="外部内的静态属性";
                outVar="外部内的成员属性";
                outMethod();
                outStaticMethod();
                System.out.println("局部内部类可以直接访问外部类的属性、静态属性、方法、静态方法！");
                System.out.println();
            }
        }

        var.append(";");
        Inner3 inner3 = new Inner3();//只能在函数内部访问
        inner3.in3_2();
    }
    //Inner3 inner3 = new Inner3(); //函数外部不能访问

    public void func2OfOuter(){
        /**4. 匿名内部类
         * 没有名字，只使用一次,没有构造方法
         * 不能继承别的类或者实现接口，它已经默认继承或者实现了new后面的类或接口
         *  可以根据接口、抽象类、类来创建
         *  拥有成员内部类的所有特征
         */

        new Test(){
            @Override
            public void funcOfTest(){
                System.out.println("匿名内部类重写外部类的func");
                //this.outVar="";
                outStaticVar="外部内的静态属性";
                outVar="外部内的成员属性";
                outMethod();
                outStaticMethod();
                System.out.println("匿名内部类可以直接访问外部类的属性、静态属性、方法、静态方法！");
                System.out.println();
            }
        }.funcOfTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("基于接口的匿名内部类，作为参数重写接口的run");
            }
        }).start();


        new Thread(){
            @Override
            public void run() {
                System.out.println("基于类的匿名内部类，重写接口的run");
            }
        }.start();

    }
}
class Test{
    private String str1="test1";
    private static String str2="test2";
    public void funcOfTest(){

        System.out.println("My func");
    }
    public static void main(String args[]){

        Outer outer=new Outer();
        Outer.Inner1 inner1=outer.new Inner1();//奇葩的 外部类.new

        int n=1;

        n++;
        inner1.in1_1();
        Outer.Inner2.in2_1();
        Outer.Inner2 inner2 = new Outer.Inner2();
        inner2.in2_2();
        outer.func1OfOuter();
        outer.func2OfOuter();
    }
}