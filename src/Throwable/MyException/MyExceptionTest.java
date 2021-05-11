package Throwable.MyException;

//用户自定义异常类只需要继承Exception，
// 构造函数，
// toString方法
public class MyExceptionTest extends Exception{
    private int detail;
    public MyExceptionTest(int detail) {
        //super(message);
        this.detail = detail;
    }
    //toString  异常的打印信息
    @Override
    public String toString() {
        return "MyExceptionTest{" +
                "detail=" + detail +
                '}';
    }
}



class test{
    static void test(int a) throws MyExceptionTest {
        if(a>10){
            throw new MyExceptionTest(a);
        }
        System.out.println("OK");
    }

    public static void main(String[] args) {
        String str1="a"+1+2;
        String str3=1+2+"a";

        System.out.println("\"a\"+1+2 = " + str1);
        System.out.println("1+2+\"a\"" + str3);

        try {
            test(11);
        } catch (MyExceptionTest myExceptionTest) {
            //myExceptionTest就是上面的toString函数的返回值
            //myExceptionTest.printStackTrace();
            System.out.println(myExceptionTest);
        }
    }
}
