package javaee.collections;

public class MathTest {
    public static void main(String[] args) {
        float f=1.123456f;
        //(Math.round(f*100))/100;保留两位小数
        float f1=(float) (Math.round(f*100))/100;//四舍五入
        float f2=(float) (Math.ceil(f*100))/100;//向上取整
        float f3=(float) (Math.floor(f*100))/100;//向下取整
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
    }
}
