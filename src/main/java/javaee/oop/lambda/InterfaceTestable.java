package javaee.oop.lambda;

public interface InterfaceTestable {
    String l="Interface var";
    void lambda();
    default void test(){
        System.out.println("interface default method");

    }

}
