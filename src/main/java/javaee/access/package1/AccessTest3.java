package javaee.access.package1;

public class AccessTest3 extends AccessTest1{
    protected void test(){
        //privateFunc();
        defaultFunc();
        protectedFunc();
        publicFunc();
    }

    /*@Override
    void publicFunc(){}//子类继承的方法的访问权限 不能小于父类中方法的访问权限*/
    @Override
    public void defaultFunc(){}//但可以大于

    public static void main(String[] args) {
        AccessTest1 accessTest1 = new AccessTest1();
        //accessTest1.privateFunc();
        accessTest1.defaultFunc();
        accessTest1.protectedFunc();
        accessTest1.publicFunc();
    }

}
