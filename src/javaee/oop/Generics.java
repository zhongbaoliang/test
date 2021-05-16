package javaee.oop;

import java.util.Objects;
//泛型
//重写equals与hashcode
public class Generics<T1,T2> {
    T1 first;
    T2 second;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Generics<?, ?> generics = (Generics<?, ?>) o;
        return Objects.equals(first, generics.first) && Objects.equals(second, generics.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public Generics(T1 first, T2 second) {
        this.second = second;
    }

    public static void main(String arg[]){


        Generics<Integer,String> g1=new Generics<>(6,"123");
        Generics<Integer,String> g2=new Generics<>(6,"123");
        System.out.println("g1==g2: "+ (g1==g2));
        System.out.println("g1.equals(g2): " + (g1.equals(g2)));
    }
}
