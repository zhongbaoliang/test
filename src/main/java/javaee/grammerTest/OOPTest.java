package javaee.grammerTest;
class A{
    public String show(D d){return "AD";}
    public String show(A a){return "AA";}
}
class B extends A{
    public String show(B b){return "BB";}
    @Override
    public String show(A a){return "BA";}
}
class C extends B{}
class D extends B{}
public class OOPTest {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(a.show(b));
        System.out.println(a.show(c));
        System.out.println(a.show(d));
        System.out.println(b.show(c));
        System.out.println(b.show(d));
    }

}
