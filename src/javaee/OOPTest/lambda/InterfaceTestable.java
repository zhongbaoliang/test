package javaee.OOPTest.lambda;

public interface InterfaceTestable {
    void lambda();
    default void test(){
        System.out.println("test lambda");
    }

}
