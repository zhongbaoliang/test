package Throwable;
//Throwable是所有异常的超类
//分为Error 和 Exception

// Error 错误：eg:如栈溢出
// RuntimeException 运行时异常：eg:函数相互调用
// 非运行时异常：eg:用户输入错误, 打开不存在的文件

// 检查性异常=非运行时异常
// 非检查型异常=Error + RuntimeException
// 编译器会检查代码是否为所有的 检查性异常 提供了异常处理


import java.util.Scanner;

//ctrl+alt+t 自动生成环绕代码
public class Test {

    public void try_catch_finally(){
        try{
            int num=5/0;
        }
        //可以有多个catch,捕获的异常类不能 由大到小（由父到子）
        //eg:
        // catch (Throwable t){
        //        System.out.println("catch the Throwable");
        //        }catch (Exception e1){
        //            System.out.println("catch the exception");
        //        }
        catch (Error e){
            System.out.println("catch the Error");
        }catch (Exception e1){
            System.out.println("catch the exception");
        }catch (Throwable t){
            System.out.println("catch the Throwable");
        }
        finally {//finally一定会执行，但是可以省略
            System.out.println("finally");
        }

    }

    //throw在函数里面，用来 主动的 抛出一种异常
    //throws在函数声明出，用来 被动的 向上一级调用者 抛出一种或多种异常；
    // throws表明函数本身不能处理异常，交给上一级处理
    public double del(int a,int b) throws ArithmeticException{
        if(b==0){
            //通过throw主动抛出异常
            throw new ArithmeticException();
        }
        else {
            return a/b;
        }

    }

    public static void main(String args[]){


        Scanner scanner= new Scanner(System.in);
        int a=scanner.nextInt(), b=scanner.nextInt();

        double c;

        try {
            c=new Test().del(a,b);
        } catch (ArithmeticException e) {
            c=0;
        }
        System.out.println(c);
    }
}
