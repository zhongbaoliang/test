package javaee.access.package2;

import javaee.access.package1.AccessTest1;


public class AccessTest2 extends AccessTest1 {
    protected void test2(){//包外子类成员
        //privateFunc();
        //defaultFunc();
        protectedFunc();
        publicFunc();

    }
    public static void main(String[] args) {//包外使用
        AccessTest1 accessTest1 = new AccessTest1();
        //accessTest1.privateFunc();
        //accessTest1.defaultFunc();
        //accessTest1.protectedFunc();
        accessTest1.publicFunc();
    }
}
