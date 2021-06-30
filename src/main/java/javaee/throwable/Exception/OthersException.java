package javaee.throwable.Exception;
//非运行时异常，又叫检查性异常
//一般是I/O错误这类问题导致的
//必须try,catch或者throws

//试图超越文件末尾继续读取文件
//试图打开不存在的文件
//试图根据给定的字符串查找Class对象，而这个字符串表示的类不存在

//ClassNotFoundException，FileNotFoundException

import java.io.FileInputStream;

public class OthersException {
    //public FileInputStream fileInputStream=new FileInputStream("F:/test.txt");
    //检查性异常，不处理时编译器会报错


    public static void main(String args[]){
        try{
            FileInputStream fileInputStream=new FileInputStream("F:/test.txt");
        }catch(Exception e){
            System.out.println("catch the exception");
        }finally {
            System.out.println("finally");
        }
    }

}
