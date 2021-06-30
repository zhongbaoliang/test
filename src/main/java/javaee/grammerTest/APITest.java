package javaee.grammerTest;

public class APITest {
    public void func1(final String str){
        //str=str+"!!";//编译时期报错
        System.out.println(str);
    }

    public void func2(String str){
        str=str+"!!";
        System.out.println(str.hashCode());
        System.out.println(str);
    }

    public static void main(String[] args) {
        String str="hello world";
        APITest apiTest=new APITest();
        apiTest.func2(str);
        System.out.println(str.hashCode());
        System.out.println(str);
    }
}
