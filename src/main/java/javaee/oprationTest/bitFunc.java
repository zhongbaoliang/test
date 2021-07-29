package javaee.oprationTest;

import org.junit.Test;

public class bitFunc {
    //支持操作数类型：byte,short,int long; char
    @Test
    public void test01(){
        //与或非,异或
        int a=2,b=3;
        int c=a&b,d=a|b,e=~a,f=a^b;
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

    }

    @Test
    public void test02(){
        //无符号左移  <<
        // 无符号右移  >>
        // 带符号右移  >>>
        int a=Integer.MAX_VALUE-1;

    }
}
