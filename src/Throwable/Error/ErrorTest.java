package Throwable.Error;

//Error类对象是由Java虚拟机生成并抛出的

import java.util.HashMap;

//栈溢出   StackOverflowError
//内存溢出  OutOfMemoryError
//类找不到  NoClassDefFoundError
//连接错误  LinkageError
public class ErrorTest {
    public void a(){
        System.out.println("func a");
        b();
    }

    public void b(){
        System.out.println("func b");
        a();
        //相互调用，异常StackOverflowError——栈溢出
    }
    public static void main(String args[]){
        try {
            new ErrorTest().a();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }

}
