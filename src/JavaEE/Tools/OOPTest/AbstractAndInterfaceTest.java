package JavaEE.Tools.OOPTest;

public class AbstractAndInterfaceTest extends AbstractTest implements InterfaceTestable {

    @Override
    public void func() {
        System.out.println("Override interface func");
    }

    @Override
    void func4() {
        System.out.println("Override abstract func4");
    }

    @Override
    public void func1() {
        System.out.println("Override abstract func1");
    }


    public static void main(String args[]){
        AbstractAndInterfaceTest abstractAndInterfaceTest=new AbstractAndInterfaceTest();
        abstractAndInterfaceTest.func1();
        abstractAndInterfaceTest.func2();
        abstractAndInterfaceTest.func3();
        abstractAndInterfaceTest.func4();
        abstractAndInterfaceTest.fun();
        abstractAndInterfaceTest.func();
    }
}
