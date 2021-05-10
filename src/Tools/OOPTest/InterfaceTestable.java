package Tools.OOPTest;

public interface InterfaceTestable {
    void func1();
    default void func2(){
        System.out.println("interface default func2");
        return ;
    }
}
