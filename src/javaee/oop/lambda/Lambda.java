package javaee.oop.lambda;

//不带参数时 ()->{}


//带多个参数时  (int a,String str)->{}
//        (a,str)->{}
//

//方法只有一行代码时{}可以去掉
//一个参数时可以去点()
//类型要么都去掉，要么都保留
public class Lambda {
    //2. 静态内部类
    static class ClassTestable2 implements InterfaceTestable{
        @Override
        public void lambda() {
            System.out.println("静态内部类 lambda2 implements InterfaceTest");
        }
    }
    public static void main(String[] args) {
        InterfaceTestable classTestable;


        classTestable=new ClassTestable1();
        classTestable.lambda();

        classTestable=new ClassTestable2();
        classTestable.lambda();

        //3. 局部内部类
        class ClassTestable3 implements InterfaceTestable{
            @Override
            public void lambda() {
                System.out.println("局部内部类 lambda3 implements InterfaceTest");
            }
        }
        classTestable=new ClassTestable3();
        classTestable.lambda();

        //4. 匿名内部类
        classTestable=new InterfaceTestable() {
            @Override
            public void lambda() {
                System.out.println("匿名内部类 lambda4 implements InterfaceTest");
            }
        };
        classTestable.lambda();


        //lambda表达式
        classTestable=()->{
            System.out.println("lambda表达式 lambda5 implements InterfaceTest");
        };
        classTestable.lambda();





    }
}

//1. 实现类
class ClassTestable1 implements InterfaceTestable{
    @Override
    public void lambda() {
        System.out.println("实现类 lambda1 implements InterfaceTest");
    }
}

