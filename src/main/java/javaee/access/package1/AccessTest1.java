package javaee.access.package1;

public class AccessTest1 {


    private void privateFunc(){}//只能在本类中使用
    void defaultFunc(){}//只能在本包中使用
    protected void protectedFunc(){}//只能在本包或者外包子类中使用
    public void publicFunc(){}//全局

}
