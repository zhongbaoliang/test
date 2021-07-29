package javaee.throwable.Exception;

//运行时异常
//数组越界异常    ArrayIndexOutOfBoundsException
//空指针异常 NullPointerException
//算术异常  ArithmeticException
//丢失资源  MissingResourceException
//...

public class RuntimeException {
    public static void main(String args[]){
        String str="123*456";
        try{
            int num=Integer.parseInt(str);
            str=Integer.toString(num);
        }catch (Exception e){
            System.out.println(e);
        }


        //字符串转为数字，异常NumberFormatException——数据格式异常
    }
}
