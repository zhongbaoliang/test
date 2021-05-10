package Tools.OOPTest;

public class AbstractAndInterfaceTest extends AbstractTest implements InterfaceTestable {

    @Override
    void func4() {
        System.out.println("Override AbstractTest func4!");
    }

    @Override
    public void func1() {
        System.out.println("Override Interface func1");
    }
    public static void main(String args[]){
        AbstractAndInterfaceTest abstractAndInterfaceTest=new AbstractAndInterfaceTest();
        abstractAndInterfaceTest.func1();
        abstractAndInterfaceTest.func2();
        abstractAndInterfaceTest.func3();
        abstractAndInterfaceTest.func4();
    }
}
